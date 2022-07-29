package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName LeetCode757
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/22 8:35
 * @Version 1.0
 */
public class LeetCode757 {
    /*
    排序：按照右边界从小到大排序
    贪：尽量靠右拿，尽量少拿
    面向WA编程
    排序问题可能习惯性的从左边考虑，这个问题可能就别扭到这里了。尽量靠右拿，才最有可能落到后续的区间里。
     */
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int a = intervals[0][1] - 1;
        int b = intervals[0][1];
        int ans = 2;
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = intervals[i];
            int l = ints[0], r = ints[1];
            if (l > b) {
                ans += 2;
                a = r - 1;
                b = r;
            } else if (l == b || l > a) {
                ans += 1;
                a = b;
                b = r;
            }
        }
        return ans;
    }
}
