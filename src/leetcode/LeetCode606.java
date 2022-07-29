package leetcode;

/**
 * @ClassName LeetCode606
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/15 11:48
 * @Version 1.0
 */
public class LeetCode606 {
    StringBuilder s = new StringBuilder();
    public String tree2str(TreeNode root) {
        swap(root);
        return s.toString();
    }

    private void swap(TreeNode root) {
        if (root == null) return;
        s.append(root.val);
        if (root.left == null && root.right == null) return;
        s.append("(");
        swap(root.left);
        if (root.right == null) {
            s.append(")");
            return;
        } else {
            s.append(")(");
        }
        swap(root.right);
        s.append(")");
    }
}
