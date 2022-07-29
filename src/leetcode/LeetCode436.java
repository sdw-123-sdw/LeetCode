package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName LeetCode436
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/20 10:11
 * @Version 1.0
 */
public class LeetCode436 {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 1) return new int[]{-1};
        int[] ints = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i][1]) {
                ints[i] = i;
                continue;
            }
            Integer integer = map.ceilingKey(intervals[i][1]);
            if (integer == null) {
                ints[i] = -1;
                continue;
            }
            ints[i] = map.get(integer);
        }
        return ints;
    }
    public int[] findRightInterval1(int[][] its) {
        int n = its.length;
        int[][] ss = new int[n][2], es = new int[n][2];
        for (int i = 0; i < n; i++) {
            ss[i] = new int[]{its[i][0], i};
            es[i] = new int[]{its[i][1], i};
        }
        Arrays.sort(ss, (a,b)->a[0]-b[0]);
        Arrays.sort(es, (a,b)->a[0]-b[0]);
        int[] ans = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            int[] cur = es[i];
            int loc = cur[0], idx = cur[1];
            while (j < n && ss[j][0] < loc) j++;
            ans[idx] = j == n ? -1 : ss[j][1];
        }
        return ans;
    }
}
