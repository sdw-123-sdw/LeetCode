package leetcode;

/**
 * @ClassName LeetCode198
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/28 10:55
 * @Version 1.0
 */
public class LeetCode198 {
    /*
    本题采用动态规划
    动态规划数组:dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
    特殊的dp[0] = nums[0],dp[1] = max(nums[0], nums[1])
     */
    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 1) return nums[0];
        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < l; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[l - 1];
    }
}
