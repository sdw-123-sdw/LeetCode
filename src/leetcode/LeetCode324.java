package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode324
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/28 8:40
 * @Version 1.0
 */
public class LeetCode324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        if (l <= 2) return;
        int[] clone = nums.clone();
        int a = l >> 1;
        int i = l >> 1;
        if ((l & 1) == 0) i = a - 1;
        for (int j = l - 1, z = 0; z < l; z++) {
            if ((z & 1) == 0) {
                nums[z] = clone[i];
                i--;
            } else {
                nums[z] = clone[j];
                j--;
            }
        }
    }
}
