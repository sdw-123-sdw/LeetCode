package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode508
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/19 15:44
 * @Version 1.0
 */
public class LeetCode508 {
    Map<Integer, Integer> map;
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{0};
        map = new HashMap<>();
        swap(root);
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>();
        for (Integer integer : set) {
            if (map.get(integer) == max) {
                list.add(integer);
            }
        }
        int size = list.size();
        int[] a = new int[size];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public int swap(TreeNode root) {
        if (root == null) return 0;
        int i = swap(root.left);
        int j = swap(root.right);
        int sum = i + j + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(map.get(sum), max);
        return sum;
    }
}
