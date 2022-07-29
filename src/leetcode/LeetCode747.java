package leetcode;

/**
 * @ClassName LeetCode747
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/13 15:38
 * @Version 1.0
 */
public class LeetCode747 {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int a = -1, b = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[b]) {
                a = b; b = i;
            } else if (a == -1 || nums[i] > nums[a]) {
                a = i;
            }
        }
        return nums[b] >= nums[a] * 2 ? b : -1;
    }
}
