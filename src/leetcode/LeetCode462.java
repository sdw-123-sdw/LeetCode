package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode462
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/19 8:31
 * @Version 1.0
 */
public class LeetCode462 {
    // 只需要选取n/2地方的值即可
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ret = 0;
        int x = nums[n / 2];
        for (int i = 0; i < n; i++) {
            ret += Math.abs(nums[i] - x);
        }
        return ret;
    }
}
