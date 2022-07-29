package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName LeetCode565
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/17 9:23
 * @Version 1.0
 */
public class LeetCode565 {
    public int arrayNesting(int[] nums) {
        // 用于记录已经标记的节点
        int l = nums.length;
        int[] ans = new int[l];
        int max = 0;
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (ans[i] == 1) continue;
            while (ans[i] == 0) {
                ans[i] = 1;
                i = nums[i];
                count++;
            }
            max = Math.max(max, count);
            count = 0;
        }
        return max;
    }
}
