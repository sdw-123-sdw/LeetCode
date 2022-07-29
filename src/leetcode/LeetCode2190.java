package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode2190
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/14 10:48
 * @Version 1.0
 */
public class LeetCode2190 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
                Integer integer = map.get(nums[i + 1]);
                if (integer > count) {
                    count = integer;
                    max = nums[i + 1];
                }
            }
        }
        return max;

    }
}
