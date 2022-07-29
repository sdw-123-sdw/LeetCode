package leetcode;

/**
 * @ClassName LeetCode1448
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/11 20:12
 * @Version 1.0
 */
public class LeetCode1448 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int count = 0;
    public int goodNodes(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        ++count;
        select(root.val, root.left);
        select(root.val, root.right);
        return count;
    }

    private void select(int max, TreeNode node) {
        if (node == null) return;
        if (node.val >= max) {
            ++count;
            max = node.val;
        }
        select(max, node.left);
        select(max, node.right);
    }
}
