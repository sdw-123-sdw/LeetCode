package study.map;

import java.util.*;

/**
 * @ClassName Kruskal
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/22 21:39
 * @Version 1.0
 */
public class Kruskal {
    public class MySets {
        public HashMap<Node, List<Node>> setMap;  // node的集合
        public MySets(List<Node> nodes) {
            for (Node node : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(node);  // 初始状态下集合中只有自己
                setMap.put(node, set);
            }
        }

        // 这条边两侧的节点是否在同一个集合中
        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        // 合并两个集合
        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            // 将toSet中的值放入fromSet中，然后将toSet中节点的集合都指向fromSet
            for (Node node : toSet) {
                fromSet.add(node);
                setMap.put(node, fromSet);
            }
        }
    }

    public Set<Edge> kruskalMST(Graph graph) {
        MySets mySets = new MySets(new ArrayList<Node>(graph.nodes.values()));
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());  // 比较器，自定义排序规则
        for (Edge edge : graph.edges) {
            queue.add(edge);
        }
        Set<Edge> set = new HashSet<>();
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if(!mySets.isSameSet(edge.from, edge.to)) {
                set.add(edge);
                mySets.union(edge.from, edge.to);
            }
        }
        return set;
    }
}

class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }
}
