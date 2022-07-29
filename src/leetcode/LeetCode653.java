package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode653
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/21 19:37
 * @Version 1.0
 */
public class LeetCode653 {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}