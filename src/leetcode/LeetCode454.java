package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode454
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/26 10:51
 * @Version 1.0
 */
public class LeetCode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int z = i + j;
                Integer integer = map.get(-z);
                if (integer != null) {
                    count += integer;
                }
            }
        }
        return count;
    }
}
