package leetcode;

/**
 * @ClassName LeetCode1791
 * @Description TODO
 * @Author: 索德文
 * @date 2022/2/18 16:31
 * @Version 1.0
 */
public class LeetCode1791 {
    public int findCenter(int[][] edges) {
        int[] edge = edges[0];
        int[] edge1 = edges[1];
        return edge[0] == edge1[0] ? edge[0] : edge[0] == edge1[1] ? edge[0] : edge[1];
    }
}
