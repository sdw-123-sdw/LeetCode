package leetcode;

import java.util.Arrays;

/**
 * @ClassName leetcode.LeetCode594
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/20 9:40
 * @Version 1.0
 */
public class LeetCode594 {
    /*
    利用滑动窗口来解决
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] == nums[nums.length - 1]) {
            return 0;
        }
        if(nums[nums.length - 1] - nums[0] == 1) {
            return nums.length;
        }
        int count = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] - nums[start] > 1) {
                if(i - start != 1) {
                    count = Math.max(count, i - start);
                }
                for (int j = start; j < i; j++) {
                    if(nums[j] != nums[j + 1]) {
                        start = j + 1;
                        break;
                    }
                }
            } else {
                count = Math.max(count, i - start + 1);
            }
        }
        return count;
    }

    public int test(int[] nums) {
        Arrays.sort(nums);
        int begin = 0,res = 0;
        for(int end = 0;end < nums.length;end++){
            while(nums[end] - nums[begin] > 1)
                begin++;
            if(nums[end] - nums[begin] == 1)
                res = Math.max(res,end - begin + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode594 leetCode594 = new LeetCode594();
        System.out.println(leetCode594.findLHS(new int[]{-3,-1,-1,-1,-3,-2}));
    }
}
