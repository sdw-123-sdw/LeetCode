package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode.LeetCode559
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/21 9:27
 * @Version 1.0
 */
public class LeetCode559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    // 深搜
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    public int dfs(Node node, int count) {
        if(node == null) {
            return count;
        }
        count++;
        int max = 0;
        for (int i = 0; i < node.children.size(); i++) {
            max = Math.max(dfs(node.children.get(i), count), max);
        }
        return Math.max(max, count);
    }
}
