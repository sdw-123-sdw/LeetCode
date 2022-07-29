package leetcode;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName LeetCode998
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/2 11:10
 * @Version 1.0
 */
public class LeetCode998 {
    private class TreeNode {
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

    // 本题考的是数组和树的关系,每次val加入数组中,都是要放置到最后一位,也就是在最右面
    // 根据题意
        // 若是val最大,那么其余所有元素应当放在左侧
        // 若是val不是最大,那么应该放在根节点右侧
    // 也就是说，val只能出现在右树上，不可能出现在左树上
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null || root.val < val) {
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            return tmp;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
