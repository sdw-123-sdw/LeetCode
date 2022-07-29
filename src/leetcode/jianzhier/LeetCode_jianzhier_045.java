package leetcode.jianzhier;

/**
 * @ClassName LeetCode_jianzhier_045
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/17 9:52
 * @Version 1.0
 */
public class LeetCode_jianzhier_045 {
    int max = 0;
    int count = 0;
    public int findBottomLeftValue(TreeNode root) {
        swap(root, 0, root.val);
        return count;
    }

    private void swap(TreeNode root, int flag, int a) {
        if (root == null) {
            if (flag > max) {
                max = flag;
                count = a;
            }
            return;
        }
        flag++;
        swap(root.left, flag, root.val);
        swap(root.right, flag, root.val);
    }

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
}
