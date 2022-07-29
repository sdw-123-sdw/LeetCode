package leetcode;

/**
 * @ClassName leetcode.LeetCode563
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/19 8:46
 * @Version 1.0
 */
public class LeetCode563 {
    int res;
    public int findTilt(TreeNode root) {
        res = 0;
        sum(root);
        return res;
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = sum(node.left);
        int sumRight = sum(node.right);
        res += Math.abs(sumLeft - sumRight);
        return node.val + sumLeft + sumRight;
    }
}
