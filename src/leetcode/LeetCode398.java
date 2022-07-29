package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode398
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/25 12:05
 * @Version 1.0
 */
public class LeetCode398 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random random = new Random();
    public LeetCode398(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
