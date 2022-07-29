package leetcode;

/**
 * @ClassName LeetCode863
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/26 9:51
 * @Version 1.0
 */
public class LeetCode863 {
    // 前面看一行的最大值
    // 侧面看一列的最大值
    public int projectionArea(int[][] grid) {
        int sum = 0;
        int left = 0;
        int ago = 0;
        int length = grid.length;
        for (int i = 0; i < length; i++) { // 行
            left = 0;
            ago = 0;
            for (int i1 = 0; i1 < length; i1++) { // 列
                if (grid[i][i1] > 0) ++sum;
                left = Math.max(left, grid[i1][i]);
                ago = Math.max(ago, grid[i][i1]);
            }
            sum = sum + left + ago;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode863 leetCode863 = new LeetCode863();
        System.out.println(leetCode863.projectionArea(new int[][]{{1, 4}, {1, 1}}));
    }
}
