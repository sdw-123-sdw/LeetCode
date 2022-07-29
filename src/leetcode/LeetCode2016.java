package leetcode;

/**
 * @ClassName LeetCode2016
 * @Description TODO
 * @Author: 索德文
 * @date 2022/2/26 15:16
 * @Version 1.0
 */
public class LeetCode2016 {
    public int maximumDifference(int[] nums) {
        // 对于i来说，其实就是j左侧的最小值，只需要维护j左侧最小值即可
        int length = nums.length;
        int returns = -1;
        int min = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > min) {
                returns = Math.max(returns, nums[i] - min);
            } else {
                min = Math.min(min, nums[i]);
            }
        }
        return returns;
    }
}
