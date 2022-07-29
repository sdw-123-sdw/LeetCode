package leetcode;

/**
 * @ClassName LeetCode1080
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/8 11:32
 * @Version 1.0
 */
public class LeetCode1080 {
    private class TreeNode {
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

    int limits;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limits = limit;
        boolean swap = swap(root, 0);
        return swap ? root : null;
    }

    private boolean swap(TreeNode root, int sum) {
        sum += root.val;
        if (root.right == null && root.left == null) {
            if (sum >= limits) {
                return true;
            } else {
                return false;
            }
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = swap(root.left, sum);
        }
        if (root.right != null) {
            right = swap(root.right, sum);
        }
        if (!left) root.left = null;
        if (!right) root.right = null;
        return left | right;
    }
}
