package leetcode;

/**
 * @ClassName leetcode.LeetCode240
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/25 20:53
 * @Version 1.0
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length - 1;
        int n = 0;
        for (; m >= 0 && n < matrix.length;) {
            if(matrix[n][m] == target) {
                return true;
            } else if(matrix[m][n] > target) {
                m--;
            } else {
                n++;
            }
        }
        return false;
    }
}
