package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode1984
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/28 11:07
 * @Version 1.0
 */
public class LeetCode1984 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        int l = nums.length;
        Arrays.sort(nums);
        if (l == k) return nums[l - 1] - nums[0];
        int start = 0;
        int end = k - 1;
        int sum = nums[end++] - nums[0];
        for (; end < l; end++) {
            sum = Math.min(sum, nums[end] - nums[++start]);
        }
        return sum;
    }
}
