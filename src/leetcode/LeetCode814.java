package leetcode;

/**
 * @ClassName LeetCode814
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/21 17:39
 * @Version 1.0
 */
public class LeetCode814 {
    public TreeNode pruneTree(TreeNode root) {
        return swap(root);
    }

    private TreeNode swap(TreeNode root) {
        if (root == null) return null;
        root.left = swap(root.left);
        root.right = swap(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
