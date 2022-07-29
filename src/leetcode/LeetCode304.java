package leetcode;

/**
 * @ClassName LeetCode304
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/17 14:58
 * @Version 1.0
 */
public class LeetCode304 {
    private int[][] sums;
    public LeetCode304(int[][] matrix) {
        // 二维数组前缀和
        // sums[i + 1][j + 1]中存储的其实就是原数组中行从0~i,列从0~j的和
        // 如何计算sums[i + 1][j + 1]?
        // 其实就是这一块的上面一块+左面一块的值,然后因为多加了一个sums[i][j],所以需要减去,然后加上原数组的第i行j列的值即可
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }
    // 1为上边界，2位下边界
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
