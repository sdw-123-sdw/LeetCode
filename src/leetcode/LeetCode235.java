package leetcode;

/**
 * @ClassName LeetCode235
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/13 16:23
 * @Version 1.0
 */
public class LeetCode235 {
    TreeNode tree = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        swap(root, p, q);
        return tree;
    }

    private void swap(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (tree == null && ((p.val >= root.val && q.val <= root.val) || (p.val <= root.val && q.val >= root.val))) {
            tree = root;
        }
        if (p.val > root.val) {
            swap(root.right, p, q);
        } else {
            swap(root.left, p, q);
        }
    }
}
