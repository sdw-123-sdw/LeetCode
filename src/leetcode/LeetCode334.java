package leetcode;

/**
 * @ClassName LeetCode334
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/12 20:38
 * @Version 1.0
 */
public class LeetCode334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        for (int i = 1; i < nums.length - 2; i++) {
            if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
