package study.map;

/**
 * @ClassName Edge
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/21 19:35
 * @Version 1.0
 */
public class Edge {
    public int weight;  // 权值/距离
    public Node from;  // 从哪
    public Node to;  // 到哪

    public Edge(int weight, Node from, Node to) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
