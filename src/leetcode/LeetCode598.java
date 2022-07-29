package leetcode;

/**
 * @ClassName leetcode.LeetCode598
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/7 17:01
 * @Version 1.0
 */
public class LeetCode598 {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            if(op[0] < m) {
                m = op[0];
            }
            if(op[1] < n) {
                n = op[1];
            }
        }
        return m * n;
    }
}
