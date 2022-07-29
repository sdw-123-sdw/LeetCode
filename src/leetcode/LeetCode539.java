package leetcode;

import java.util.Comparator;
import java.util.List;

/**
 * @ClassName LeetCode539
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/18 10:40
 * @Version 1.0
 */
public class LeetCode539 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n >= 1440) return 0;
        int[] cnts = new int[1440 * 2 + 10];
        for (String s : timePoints) {
            String[] ss = s.split(":");
            int h = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
            if (cnts[h * 60 + m] != 0) return 0;
            cnts[h * 60 + m]++;
            cnts[h * 60 + m + 1440]++;
        }
        int ans = 1440, last = -1;
        for (int i = 0; i <= 1440 * 2 && ans != 0; i++) {
            if (cnts[i] == 0) continue;
            if (cnts[i] > 1) ans = 0;
            else if (last != -1) ans = Math.min(ans, i - last);
            last = i;
        }
        return ans;
    }
}
