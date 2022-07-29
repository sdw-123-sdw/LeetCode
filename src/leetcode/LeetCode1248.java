package leetcode;

import java.util.HashMap;

/**
 * @ClassName LeetCode1248
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/22 9:14
 * @Version 1.0
 */
public class LeetCode1248 {
    // 双指针,滑动窗口
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] odd = new int[n + 2];
        int ans = 0, cnt = 0;
        for (int i = 0; i < n; ++i) {
            if ((nums[i] & 1) != 0) {
                odd[++cnt] = i;
            }
        }
        odd[0] = -1;
        odd[++cnt] = n;
        for (int i = 1; i + k <= cnt; ++i) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }
}
