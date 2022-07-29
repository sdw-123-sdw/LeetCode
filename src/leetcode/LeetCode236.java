package leetcode;

/**
 * @ClassName LeetCode236
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/10 10:07
 * @Version 1.0
 */
public class LeetCode236 {
    TreeNode count = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        swap(root, p.val, q.val);
        return count == null ? root : count;
    }

    private boolean swap(TreeNode root, int p, int q) {
        if (root == null) return false;
        boolean flag = false;
        if (root.val == p || root.val == q) {
            flag = true;
        }
        boolean swap = swap(root.left, p, q);
        boolean swap1 = swap(root.right, p, q);
        if (count == null) {
            if (flag) {
                if (swap | swap1) {
                    count = root;
                }
                return true;
            } else {
                if (swap && swap1) {
                    count = root;
                    return true;
                }
            }
        }
        return flag | swap | swap1;
    }
}
