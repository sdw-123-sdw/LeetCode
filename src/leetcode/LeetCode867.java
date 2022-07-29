package leetcode;

/**
 * @ClassName LeetCode867
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/16 16:33
 * @Version 1.0
 */
public class LeetCode867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < m; i1++) {
                ints[i][i1] = matrix[i1][i];
            }
        }
        return ints;
    }
}
