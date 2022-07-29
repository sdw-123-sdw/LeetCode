package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode1380
 * @Description TODO
 * @Author: 索德文
 * @date 2022/2/15 21:40
 * @Version 1.0
 */
public class LeetCode1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] min = new int[m];
        int[] max = new int[n];
        for (int i = 0; i < m; i++) {
            min[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min[i] = Math.min(min[i], matrix[i][j]);
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == min[i]) {
                    if (matrix[i][j] == max[j]) {
                        list.add(min[i]);
                    }
                    break;
                }
            }
        }
        return list;
    }
}
