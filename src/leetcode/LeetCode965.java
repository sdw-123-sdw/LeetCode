package leetcode;

/**
 * @ClassName LeetCode965
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/24 9:53
 * @Version 1.0
 */
public class LeetCode965 {
    int flag;
    public boolean isUnivalTree(TreeNode root) {
        flag = root.val;
        return swap(root);
    }

    private boolean swap(TreeNode root) {
        if (root == null) return true;
        if (root.val != flag) return false;
        boolean a = swap(root.left);
        if (a) {
            a = swap(root.right);
        }
        return a;
    }

    private boolean swap2(TreeNode root) {
        if(root==null){
            return true;
        }
        return root.val==flag && swap2(root.left) && swap2(root.right);
    }
}
