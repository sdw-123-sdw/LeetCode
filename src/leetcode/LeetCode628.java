package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode628
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/14 10:20
 * @Version 1.0
 */
public class LeetCode628 {
    public int maximumProduct(int[] nums) {
        // if (nums.length == 3) return nums[0] * nums[1] * nums[2];
        // Arrays.sort(nums);
        // int l = nums.length;
        // return Math.max(nums[0] * nums[1] * nums[l - 1], nums[l - 1] * nums[l - 2] * nums[l - 3]);

        int min1 = Integer.MAX_VALUE, min2 = min1;
        int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
