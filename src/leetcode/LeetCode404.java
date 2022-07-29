package leetcode;

/**
 * @ClassName leetcode.LeetCode404
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/26 21:26
 * @Version 1.0
 */
public class LeetCode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        return sums(root, 0);
    }

    public int sums(TreeNode root, int sum) {
        if(root == null) {
            return sum;
        }
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        sum = sums(root.left, sum);
        sum = sums(root.right, sum);
        return sum;
    }
}
