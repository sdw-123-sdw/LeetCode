package leetcode;

/**
 * @ClassName LeetCode513
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/22 8:45
 * @Version 1.0
 */
public class LeetCode513 {
    int max = 0;
    int flag = 0;
    public int findBottomLeftValue(TreeNode root) {
        swap(root, 0);
        return flag;
    }
    // 深搜
    private void swap(TreeNode root, int count) {
        if (root == null) return;
        count++;
        if (root.left != null || root.right != null) {
            swap(root.left, count);
            swap(root.right,  count);
        } else {
            if (count > max) {
                flag = root.val;
                max = count;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode513 leetCode513 = new LeetCode513();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null), new TreeNode(3, new TreeNode(5, new TreeNode(7, null, null), null), new TreeNode(6, null, null)));
        System.out.println(leetCode513.findBottomLeftValue(root));
    }
}
