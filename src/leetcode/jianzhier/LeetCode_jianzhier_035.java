package leetcode.jianzhier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName leetcode.jianzhier.LeetCode_jianzhier_035
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/9 12:04
 * @Version 1.0
 */
public class LeetCode_jianzhier_035 {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 24 * 60) {
            return 0;
        }
        List<Integer> time = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            time.add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        }
        Collections.sort(time);
        time.add(time.get(0) + 24 * 60);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < time.size(); i++) {
            min = Math.min(time.get(i) - time.get(i - 1), min);
        }
        return min;
    }
}
