package study.map;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName Prim
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/23 16:51
 * @Version 1.0
 */
public class Prim {
    public Set<Edge> primMST(Graph graph) {
        // 解锁的边进小根堆
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();  // 已经走过的点放在这个集合中
        Set<Edge> edges = new HashSet<>();  // 依次挑选的边在edges里
        for (Node node : graph.nodes.values()) { // 随便挑选一个点,为了防止森林这种情况出现
            // node是开始点
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) {  // 解锁这个点连接的边
                    queue.add(edge);
                }
                while (!queue.isEmpty()) {
                    Edge edge = queue.poll();  // 对最小的边弹出
                    Node to = edge.to;  // 获取其to节点
                    if(!set.contains(to)) {  // 看看是否已经被访问过
                        set.add(to);  // 将点加入集合中
                        edges.add(edge);  // 将边加入集合中
                        for (Edge edge1 : to.edges) {  // 将新解锁的边放入小根堆中
                            queue.add(edge1);
                        }
                    }
                }
            }
        }
        return edges;
    }
}
