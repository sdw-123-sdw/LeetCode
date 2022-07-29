package study.map;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName Graph
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/21 19:34
 * @Version 1.0
 */
public class Graph {
    public HashMap<Integer, Node> nodes;  // 边集  integer 几号城市，node 具体的点集
    public HashSet<Edge> edges;  // 点集

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
