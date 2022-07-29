package leetcode;

/**
 * @ClassName LeetCode1022
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/30 13:35
 * @Version 1.0
 */
public class LeetCode1022 {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        swap(root, 0);
        return sum;
    }

    private void swap(TreeNode root, int i) {
        if (root == null) return;
        i = (i << 1) | root.val;
        if (root.left == null && root.right == null) {
            sum += i;
            return;
        }
        swap(root.left, i);
        swap(root.right, i);
    }
}
