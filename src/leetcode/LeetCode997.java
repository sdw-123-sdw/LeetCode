package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode997
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/19 10:20
 * @Version 1.0
 */
public class LeetCode997 {
    // 计算出入度
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1], out = new int[n + 1];
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            in[b]++; out[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) return i;
        }
        return -1;
    }
}
