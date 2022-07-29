package leetcode;

/**
 * @ClassName LeetCode129
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/11 20:47
 * @Version 1.0
 */
public class LeetCode129 {
    public static class TreeNode {
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
    int count = 0;
    public int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        String number = root.val + "";
        sum(root.left, number);
        sum(root.right, number);
        return count;
    }

    private void sum(TreeNode node, String number) {
        if (node == null) return;
        number += node.val;
        if (node.left == null && node.right == null) {
            count += Integer.parseInt(number);
            return;
        }
        sum(node.left, number);
        sum(node.right, number);
    }

    int counts = 0;
    public int sumNumbers2(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        StringBuffer number = new StringBuffer();
        number.append(root.val);
        sum2(root.left, number, number.length());
        sum2(root.right, number, number.length());
        return counts;
    }

    private void sum2(TreeNode node, StringBuffer number, int length) {
        if (node == null) return;
        number.append(node.val);
        if (node.left == null && node.right == null) {
            counts += Integer.parseInt(number.toString());
            number.delete(length, number.length());
            return;
        }
        sum2(node.left, number, number.length());
        sum2(node.right, number, number.length());
        number.delete(length, number.length());
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        LeetCode129 leetCode129 = new LeetCode129();
        System.out.println(leetCode129.sumNumbers2(treeNode));
        System.out.println(leetCode129.sumNumbers(treeNode));
    }
}
