package weeklyEvents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName week_7_24_002
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/24 10:35
 * @Version 1.0
 */
public class week_7_24_002 {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> set = new HashMap<>();
        int count = 0;
        // 先存储行的
        for (int[] ints : grid) {
            StringBuilder s = new StringBuilder();
            for (int anInt : ints) {
                s.append(anInt + ",");
            }
            set.put(s.toString(), set.getOrDefault(s.toString(), 0) + 1);
        }
        // 在存储列的
        for (int i = 0; i < grid[0].length; i++) {
            StringBuilder s = new StringBuilder();
            for (int i1 = 0; i1 < grid.length; i1++) {
                s.append(grid[i1][i] + ",");
            }
            if (set.containsKey(s.toString())) {
                count += set.get(s.toString());
            }
        }
        return count;
    }
}
