package leetcode;

/**
 * @ClassName LeetCode1252
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/7 8:30
 * @Version 1.0
 */
public class LeetCode1252 {
    // 1. 模拟
    // 2. 数学
    public int oddCells(int m, int n, int[][] indices) {
        // 第一行存储行，第二行存储列
        boolean r[] = new boolean[m];
        boolean c[] = new boolean[n];
        // 简单的将那一行和列标志位翻转
        for (int i = 0; i < indices.length; i++) {
            r[indices[i][0]] = !r[indices[i][0]];
            c[indices[i][1]] = !c[indices[i][1]];
        }
        int rCount = 0;
        int cCount = 0;
        for (boolean b : r) {
            if (b) ++rCount;
        }
        for (boolean b : c) {
            if (b) ++cCount;
        }
        return rCount * (n - cCount) + cCount * (m - rCount);
    }
}
