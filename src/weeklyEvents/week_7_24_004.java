package weeklyEvents;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName week_7_24_004
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/24 11:14
 * @Version 1.0
 */
public class week_7_24_004 {
    public long countExcellentPairs(int[] nums, int k) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        // 先进行自己和自己比较，并且去重
        long count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                set.add(nums[i]);
                if (swap(nums[i] & nums[i]) + swap(nums[i] | nums[i]) >= k) {
                    count++;
                }
            }
        }
        for (Integer i : set) {
            for (Integer j : set) {
                if (i != j) {
                    if (swap(i & j) + swap(i | j) >= k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int swap(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
