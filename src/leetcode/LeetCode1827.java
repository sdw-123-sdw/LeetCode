package leetcode;

/**
 * @ClassName LeetCode1827
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/26 11:09
 * @Version 1.0
 */
public class LeetCode1827 {
    public int minOperations(int[] nums) {
        if (nums.length == 1) return 0;
        int sum = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int j = nums[i - 1] + 1 - nums[i];
                sum += j;
                nums[i] += j;
            }
        }
        return sum;
    }
}
