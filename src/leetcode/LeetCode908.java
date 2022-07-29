package leetcode;

/**
 * @ClassName LeetCode908
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/30 10:40
 * @Version 1.0
 */
public class LeetCode908 {
    public int smallestRangeI(int[] nums, int k) {
        int min = 10001;
        int max = -1;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
         if (max - min <= 2 * k) {
             return 0;
         } else {
             return max - min - 2 * k;
         }
    }
}
