package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName LeetCode1110
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/26 9:31
 * @Version 1.0
 */
public class LeetCode1110 {
    List<TreeNode> list;
    Set<Integer> set = new HashSet<>();
    // i是信号量，如果为0不删，1为删
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return null;
        for (int i : to_delete) {
            set.add(i);
        }
        list = new ArrayList<>();
        swap(root, 1);
        return list;
    }

    private boolean swap(TreeNode root, int i) {
        if (root == null) return false;
        int j = 1;
        if (!set.contains(root.val)) {
            j = 0;
        } else {
            j = 1;
        }
        boolean z = swap(root.left, j);
        if (z) {
            root.left = null;
        }
        boolean k = swap(root.right, j);
        if (k) {
            root.right = null;
        }
        if (j == 0) {
            if (i == 1) {
                list.add(root);
            }
            return false;
        }
        return true;
    }
}
