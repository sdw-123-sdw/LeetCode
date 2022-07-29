package leetcode;

/**
 * @ClassName LeetCode1672
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/14 8:32
 * @Version 1.0
 */
public class LeetCode1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int count = 0;
        for (int[] account : accounts) {
             count = 0;
            for (int i : account) {
                count += i;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
