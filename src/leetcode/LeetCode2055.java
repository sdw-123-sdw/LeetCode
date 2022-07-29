package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode2055
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/8 10:33
 * @Version 1.0
 */
public class LeetCode2055 {
    // 利用前缀和
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = cs.length, m = queries.length;
        int[] l = new int[n], r = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0, j = n - 1, p = -1, q = -1; i < n; i++, j--) {
            if (cs[i] == '|') p = i;
            if (cs[j] == '|') q = j;
            l[i] = p; r[j] = q;
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int c = r[a], d = l[b];
            if (c != -1 && c <= d) ans[i] = sum[d + 1] - sum[c];
        }
        return ans;
    }

    public int[] platesBetweenCandles1(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int m = queries.length;
        int[] r = new int[n], l = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0, j = n - 1, p = -1, q = -1; i < n; i++, j--) {
            if (chars[i] == '|') p = i; // 从前面开始，遇到蜡烛，记录蜡烛所在的下标
            if (chars[j] == '|') q = j; // 从后面开始，遇到蜡烛，记录蜡烛所在的下标
            l[i] = p;
            r[j] = q; // 如果遇到蜡烛了，记录蜡烛的下标，如果没有遇到，记录前一个蜡烛的下标
            sum[i + 1] = sum[i] + (chars[i] == '*' ? 1 : 0); // 记录前面有多少个盘子
        }
        int[] returns = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int c = r[a]; // 取到对应位置蜡烛的位置
            int d = l[b]; // 取到对应位置蜡烛的位置
            if (c != 1 && c <= d) returns[i] = sum[d + 1] - sum[c]; // 目的数组的右端蜡烛前面的盘子数，减去左端蜡烛前面有的盘子数，最后的结果保存到对应位置即可
        }
        return returns;
    }
}
