package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode442
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/8 8:15
 * @Version 1.0
 */
public class LeetCode442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 2 * n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
