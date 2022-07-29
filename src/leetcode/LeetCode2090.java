package leetcode;

/**
 * @ClassName LeetCode2090
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/18 11:47
 * @Version 1.0
 */
public class LeetCode2090 {
    public int[] getAverages(int[] nums, int k) {
        int n  = nums.length;
        int len = k*2+1;
        long sum  = 0L;
        int i = 0;
        int[] ans = new int[n];
        //前面2k+1阶段只累加
        for(;i<n&&i<len-1; i++){
            ans[i]=-1;
            sum+=nums[i];
        }

        //后面的满足规律加一个减一个，结果放在-k位置
        for(; i < n; i++){
            ans[i]=-1;
            sum+=nums[i];
            ans[i-k]= (int) (sum/len);
            sum-=nums[i-len+1];
        }
        return ans;
    }
}
