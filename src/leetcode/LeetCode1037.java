package leetcode;

/**
 * @ClassName LeetCode1037
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/8 9:15
 * @Version 1.0
 */
public class LeetCode1037 {
    public boolean isBoomerang(int[][] points) {
        // 使用向量
        int[] x1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] y1 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return y1[1] * x1[0] - y1[0] * x1[1] != 0;
    }
}
