package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode1
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/26 9:22
 * @Version 1.0
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
