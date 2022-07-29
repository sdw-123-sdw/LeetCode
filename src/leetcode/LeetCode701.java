package leetcode;

/**
 * @ClassName LeetCode701
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/18 9:23
 * @Version 1.0
 */
public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val, null, null);
        swap(root, val);
        return root;
    }

    private void swap(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val, null, null);
            } else {
                swap(root.right, val);
            }
        }
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val, null, null);
            } else {
                swap(root.left, val);
            }
        }
    }

    // 方法二
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(val < root.val){
            root.left = insertIntoBST2(root.left, val);
        }

        if(val > root.val){
            root.right = insertIntoBST2(root.right, val);
        }

        return root;
    }
}
