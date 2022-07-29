package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode219
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/19 0:35
 * @Version 1.0
 */
public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode219 leetCode219 = new LeetCode219();
        System.out.println(leetCode219.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
