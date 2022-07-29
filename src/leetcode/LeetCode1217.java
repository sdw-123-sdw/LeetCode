package leetcode;

/**
 * @ClassName LeetCode1217
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/8 10:51
 * @Version 1.0
 */
public class LeetCode1217 {
    public int minCostToMoveChips(int[] position) {
        // int n = position.length, ans = Integer.MAX_VALUE;
        // for (int i = 0; i < n; i++) {
        //     int a = position[i], cur = 0;
        //     for (int j = 0; j < n; j++) {
        //         int b = position[j];
        //         cur += Math.abs(a - b) & 1;
        //     }
        //     ans = Math.min(ans, cur);
        // }
        // return ans;

        /*
        其实只要保证数字所在位置的奇偶性不变即可，如果改变那么就是1，最终只需要选出小的即可
         */
        int n = position.length, a = 0;
        for (int i : position) a += i % 2;
        return Math.min(a, n - a);
    }
}
