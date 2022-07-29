package leetcode;

/**
 * @ClassName LeetCode_interview_04_06
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/16 15:21
 * @Version 1.0
 */
public class LeetCode_interview_04_06 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        TreeNode ans = inorderSuccessor(root.left, p);
        return ans == null ? root : ans;
    }
}
