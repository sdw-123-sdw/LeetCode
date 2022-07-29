package leetcode;

import java.util.Random;

/**
 * @ClassName LeetCode961
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/21 19:28
 * @Version 1.0
 */
public class LeetCode961 {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Random random = new Random();

        while (true) {
            int x = random.nextInt(n), y = random.nextInt(n);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }
}
