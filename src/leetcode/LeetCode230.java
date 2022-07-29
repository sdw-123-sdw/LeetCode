package leetcode;

/**
 * @ClassName leetcode.LeetCode230
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/17 14:36
 * @Version 1.0
 */
/*
 * 其实就是中序遍历的结果，然后挑选对应的
 */
class TreeNode {
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
public class LeetCode230 {
    int count = 0;
    int target = Integer.MIN_VALUE;
    public int test(TreeNode root, int k) {
        if(k == 1 && root.left == null && target == Integer.MIN_VALUE) {
            target = root.val;
        }
        if(count != k && root.left != null) {
            test(root.left, k);
        }
        count++;
        if(count == k && target == Integer.MIN_VALUE) {
            target = root.val;
            return root.val;
        }
        if(count != k && root.right != null) {
            test(root.right, k);
        }
        if(count == k && target == Integer.MIN_VALUE) {
            target = root.val;
            return root.val;
        }
        return root.val;
    }

    public int kthSmallest(TreeNode root, int k) {
        test(root, k);
        return target;
    }
}

class Test01 {
    public static void main(String[] args) {
        LeetCode230 leetCode230 = new LeetCode230();
        TreeNode treeNode = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1, null, null), null), new TreeNode(4, null, null)), new TreeNode(6, null, null));
        TreeNode treeNode1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2, null, null)), new TreeNode(4, null, null));
        System.out.println(leetCode230.kthSmallest(treeNode, 1));
    }
}
