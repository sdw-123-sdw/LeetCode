package leetcode;

import javax.sql.PooledConnection;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName LeetCode919
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/25 9:41
 * @Version 1.0
 */
public class LeetCode919 {
    Queue<TreeNode> treeNode;
    TreeNode root;
    public LeetCode919(TreeNode root) {
        this.root = root;
        this.treeNode = new ArrayDeque<>();
        Queue<TreeNode> flag = new ArrayDeque<>();
        flag.add(root);
        while (!flag.isEmpty()) {
            TreeNode poll = flag.poll();
            if (poll.left != null) {
                flag.add(poll.left);
            }
            if (poll.right != null) {
                flag.add(poll.right);
            }
            if (!(poll.left != null && poll.right != null)) {
                treeNode.add(poll);
            }
        }
    }

    public int insert(int val) {
        TreeNode t = new TreeNode(val);
        TreeNode peek = treeNode.peek();
        if (peek.left == null) {
            peek.left = t;
        } else {
            peek = treeNode.poll();
            peek.right = t;
        }
        treeNode.add(t);
        return peek.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
