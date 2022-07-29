package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode1261
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/26 10:50
 * @Version 1.0
 */
public class LeetCode1261 {
    Set<Integer> set = new HashSet<>();
    public LeetCode1261(TreeNode root) {
        root.val = 0;
        set.add(root.val);
        swap(root.left, 0, true);
        swap(root.right, 0, false);
    }

    // true为左，false为右
    private void swap(TreeNode root, int fatherVal, boolean flag) {
        if (root == null) return;
        if (flag) {
            root.val = 2 * fatherVal + 1;
        } else {
            root.val = 2 * fatherVal + 2;
        }
        set.add(root.val);
        swap(root.left, root.val, true);
        swap(root.right, root.val, false);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
