package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode590
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/12 14:21
 * @Version 1.0
 */
public class LeetCode590 {
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
    public List<Integer> postorder(Node root) {
        swap(root);
        return list;
    }

    public void swap(Node root) {
         if (root == null) return;
        for (Node child : root.children) {
            swap(child);
        }
        list.add(root.val);
    }
}
