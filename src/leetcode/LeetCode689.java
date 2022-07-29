package leetcode;

/**
 * @ClassName LeetCode689
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/8 17:17
 * @Version 1.0
 */
public class LeetCode689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] result = new int[3];
        if (nums.length == 1) {
            result[0] = 0;
            return result;
        } else if (nums.length == 2) {
            result[0] = 0;
            result[1] = 1;
            return result;
        }
        int start1 = 0, end1 = start1 + k - 1;
        int start2 = nums.length / 3, end2 = start2 + k - 1;
        int start3 = (nums.length / 3) * 2, end3 = start3 + k - 1;
        int max = 0;
        for (int i = 0; i <= nums.length / 3; i++) {
            if (nums[3] == 0) {
                if (start1 != end1) {
                    result[0] = Math.abs(nums[start1] - nums[end1]);
                } else {
                    result[0] = nums[start1];
                }
                if (start2 != end2) {
                    result[1] = Math.abs(nums[start2] - nums[end2]);
                } else {
                    result[1] = nums[start2];
                }
                if (start3 != end3) {
                    result[2] = Math.abs(nums[start3] - nums[end3]);
                } else {
                    result[2] = nums[start3];
                }
            }
            
        }
        return result;
    }
}
