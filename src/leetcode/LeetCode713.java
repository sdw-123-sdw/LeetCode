package leetcode;

/**
 * @ClassName LeetCode713
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/5 14:38
 * @Version 1.0
 */
public class LeetCode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int start = 0;
        int end = 0;
        int l = nums.length;
        while (start < l) {
            int sum = 1;
            for (end = start; end < l; ++end) {
                if (start == end && nums[start] < k){
                    sum *= nums[end];
                    ++count;
                    continue;
                }
                sum *= nums[end];
                if (sum < k) {
                    ++count;
                } else {
                    break;
                }
            }
            ++start;
        }
        return count;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int len = nums.length;
        int ans = -0;
        int m = 1;
        int l = 0;
        int r = 0;
        if(k <= 1) {
            return 0;
        }
        while(r < len) {
            m = m * nums[r];
            while(m >= k){
                m = m / nums[l];
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }



    public static void main(String[] args) {
        LeetCode713 leetCode713 = new LeetCode713();
        System.out.println(leetCode713.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
