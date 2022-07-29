package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leetcode.LeetCode1218
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/5 10:48
 * @Version 1.0
 */
public class LeetCode1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer integer = map.get(i - difference);
            if(integer != null) {
                map.put(i, integer + 1);
                max = max >= (integer + 1) ? max : (integer + 1);
            } else {
                map.put(i, 1);
                max = max > 1 ? max : 1;
            }
        }
        return max;
    }
    public int longestSubsequence1(int[] arr, int difference) {
        int[] dp = new int[50010];
        for(int i = 0; i < arr.length; i++){
            arr[i] += 20000;
            int t = arr[i] - difference;
            dp[arr[i]] = dp[t]+1;
        }
        int res = 0;
        for(int i = 0; i <= 50009; i++) res = Math.max(res,dp[i]);
        return res;
    }
    public static void main(String[] args) {
        LeetCode1218 leetCode1218 = new LeetCode1218();
        System.out.println(leetCode1218.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
    }
}
