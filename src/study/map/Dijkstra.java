package study.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName Dijkstra
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/24 11:05
 * @Version 1.0
 */
public class Dijkstra {
    /**
     *
     * @param node 目标节点，从该节点出发
     * @return
     */
    public static HashMap<Node, Integer> dijkstra1(Node node) {
        // 这个map中存放的是目标节点到其余节点的距离
        // key：从node到key
        // value：从node到key的最短距离
        // 如果在表中没有某个节点的记录，那么含义是从node出发，到该节点的距离为正无穷
        /*
                A   B   C   D
            A   0   无穷 无穷 无穷
         */
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(node, 0);
        // 已经求过距离的节点，存在该set中，以后再也不碰
        HashSet<Node> selectedNode = new HashSet<>();
        Node minNode= getMinDistanceAndUnselectedNode(selectedNode, distanceMap); // 获取没有被锁的最小距离
        while (minNode != null) {
            int distance = distanceMap.get(minNode); // 获取目标节点到他的最小值
            for (Edge edge : minNode.edges) { // 遍历他的边
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)) { // 判断该节点是不是在map中,也就A到他的距离是不是正无穷
                    distanceMap.put(toNode, distance + edge.weight); // 是,肯定这个距离要比正无穷大,所以put将这条数据加入
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight)); // 不是,也就是距离不为正无穷,那就判断这个点已有的值和这个最小值+最小值到这个点的距离的最小值更新到这个值中
                }
            }
            selectedNode.add(minNode); // 遍历完这个点的所有边后,将这个点锁住
            minNode = getMinDistanceAndUnselectedNode(selectedNode, distanceMap);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashSet<Node> touchedNodes, HashMap<Node, Integer> distanceMap) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> nodeIntegerEntry : distanceMap.entrySet()) {
            Node node = nodeIntegerEntry.getKey();
            int distance = nodeIntegerEntry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    /*---------------------------------改进后的算法，使用堆---------------------------------*/
    public class NodeRecord {
        public Node node; // 哪一个节点
        public int distance; // head到他的最短距离
        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    // 堆
    public class NodeHeap {

        private Node[] nodes; // 堆数组
        private HashMap<Node, Integer> heapIndexMap; // node所在位置,堆上的index是其value值
        private HashMap<Node, Integer> distanceMap; // node到head的最短距离
        private int size;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 如果记录第一次添加，就add，如果距离比记录的小，就update， 如果距离比记录的大，就ignore
        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (inHeap(node)) { // 在堆中
                distanceMap.put(node, Math.min(distanceMap.get(node), distance)); // 之前距离head的距离和现在新的距离比谁小放谁
                insertHeapify(node, heapIndexMap.get(node)); //
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size- 1]);
            nodes[size - 1] = null;
            heapify(0, --size);
            return nodeRecord;
        }

        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) { // 看看该节点的值是否比其父节点的值还要小
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1 : left; // 比较出左右两个孩子谁小
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index; // 小的那个孩子和父节点作比较,返回小的
                if (smallest == index) { // 如果父节点小,brake,否则的话交换两个的值
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        // node是否进来过
        // 弹出后,在数组中移除,但是在map中还是会保存,记录变为-1
        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        // 是否在堆上
        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        // 交换
        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node node = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = node;
        }
    }

    /**
     *
     * @param head 头节点
     * @param size 节点个数
     * @return
     */
    // 从head出发，所有head能到达的节点，生成到达每个节点的最小路径记录并返回
    public HashMap<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);// 如果记录第一次添加，就add，如果距离比记录的小，就update， 如果距离比记录的大，就ignore
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance); // head到我的最短距离 + 这条边的权重（值），就是另一个节点的距离，判断大小或者是否加过没
            }
            result.put(cur, distance);
        }
        return result;
    }
}
