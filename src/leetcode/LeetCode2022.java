package leetcode;

/**
 * @ClassName LeetCode2022
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/1 14:18
 * @Version 1.0
 */
public class LeetCode2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];
        int[][] year2022 = new int[m][n];
        for (int i = 0, idx = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                year2022[i][j] = original[idx++];
            }
        }
        return year2022;
    }
}
