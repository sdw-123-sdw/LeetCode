package leetcode;

/**
 * @ClassName LeetCode1413
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/23 9:20
 * @Version 1.0
 */
public class LeetCode1413 {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        if (min > 0) return 1;
        else return 1 - min;
    }
}
