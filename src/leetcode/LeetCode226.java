package leetcode;

/**
 * @ClassName LeetCode226
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/31 10:23
 * @Version 1.0
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        TreeNode flag = null;
        flag = root.left;
        root.left = root.right;
        root.right = flag;
        swap(root.left);
        swap(root.right);
    }
}
