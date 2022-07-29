package leetcode;

/**
 * @ClassName leetcode.LeetCode700
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/26 8:44
 * @Version 1.0
 */
public class LeetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val){
                root = root.right;
            } else {
                break;
            }
        }
        return root == null ? null : root;
    }
}
