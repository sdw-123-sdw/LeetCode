package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode_LCP_44
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/5 11:16
 * @Version 1.0
 */
public class LeetCode_LCP_44 {
    Set<Integer> set = new HashSet<>();
    public int numColor(TreeNode root) {
        swap(root);
        return set.size();
    }

    private void swap(TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        swap(root.left);
        swap(root.right);
    }
}
