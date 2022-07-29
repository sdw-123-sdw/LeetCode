package study.map;

import java.util.ArrayList;

/**
 * @ClassName Node
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/21 19:36
 * @Version 1.0
 */
public class Node {
    public int value;  // 节点值/编号
    public int in;  // 入度
    public int out;  // 出度
    public ArrayList<Node> nexts;  // 从自己出发直接相邻的点
    public ArrayList<Edge> edges;  // 自己所拥有的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
