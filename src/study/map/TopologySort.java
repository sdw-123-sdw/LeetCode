package study.map;

import java.util.*;

/**
 * @ClassName TopologySort
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/22 17:20
 * @Version 1.0
 */
public class TopologySort {
    public List<Node> sortedTopology(Graph graph) {
        // key：某一个node
        // value：该点剩余入度
        HashMap<Node, Integer> map = new HashMap<>();
        // 入度为0的点，进入到这个队列中
        Queue<Node> queue = new LinkedList<>();
        // graph.nodes.values()生成集合
        for (Node value : graph.nodes.values()) {
            map.put(value, value.in);
            if (value.in == 0) {
                queue.add(value);
            }
        }
        // 进行拓扑排序，将结果依次放入
        List<Node> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                map.put(next, map.get(next) - 1);
                if (map.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
