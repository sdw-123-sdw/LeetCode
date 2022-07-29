package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode589
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/10 10:45
 * @Version 1.0
 */
public class LeetCode589 {
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
    List<Integer> list = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node child : root.children) {
            swap(child);
        }
        return list;
    }

    private void swap(Node root) {
        if (root == null) return;
        list.add(root.val);
        for (Node child : root.children) {
            swap(child);
        }
    }
}
