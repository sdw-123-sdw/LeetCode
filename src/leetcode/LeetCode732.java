package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName LeetCode732
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/6 7:03
 * @Version 1.0
 */
public class LeetCode732 {
    // 存储的是有几个日程
    TreeMap<Integer, Integer> map;
    public LeetCode732() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
        }
        return ans;
    }
}
