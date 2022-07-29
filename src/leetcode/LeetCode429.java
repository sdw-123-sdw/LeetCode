package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName LeetCode429
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/8 8:38
 * @Version 1.0
 */
public class LeetCode429 {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        // 双端队列，DFS应用，层序遍历，同一层节点的子节点放入一个list中
        Deque<Node> d = new ArrayDeque<>();
        if (root != null) d.addLast(root);
        while (!d.isEmpty()) {
            int size = d.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                Node t = d.pollFirst();
                for (Node node : t.children) d.addLast(node);
                list.add(t.val);
            }
            ans.add(list);
        }
        return ans;
    }
}
