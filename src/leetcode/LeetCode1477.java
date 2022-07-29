package leetcode;

/**
 * @ClassName LeetCode1477
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/12 9:28
 * @Version 1.0
 */
public class LeetCode1477 {
    // 看错题了，这个是有重叠版
    public int minSumOfLengths(int[] arr, int target) {
        if (arr.length == 1) return -1;
        int start = 0;
        int end = 0;
        int arg0 = -1;
        int arg1 = -1;
        int l = arr.length;
        int sum = 0;
        for (; end < l; end++) {
            if (sum + arr[end] <= target) {
                sum += arr[end];
            } else break;
        }
        arg0 = sum == target ? end - start : -1;
        for (; end < l; end++) {
            sum += arr[end];
            while (sum > target && start <= end) {
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                if (arg0 == -1) {
                    arg0 = end - start + 1;
                } else if (arg1 == -1) {
                    arg1 = end - start + 1;
                } else {
                    if (arg0 > arg1) {
                        arg0 = Math.min(arg0, end - start + 1);
                    } else {
                        arg1 = Math.min(arg1, end - start + 1);
                    }
                }
            }
        }
        if (arg0 != -1 && arg1 != -1) {
            return arg0 + arg1;
        } else return -1;
    }

    // 符合题意，无重叠版
    public int minSumOfLengths1(int[] arr, int target) {
        int N = arr.length;
        int left = 0, right = 0;
        int sum = 0;
        int[] dp = new int[N];
        int INF = 100001;
        dp[0] = arr[0] == target ? 1 : INF;
        int minLen = INF;
        while (right < N) {
            if (right > 0) {
                dp[right] = dp[right - 1];
            }
            sum += arr[right];
            while (sum >= target) {
                if (sum == target) {
                    int len = right - left + 1;
                    dp[right] = Math.min(dp[right], len);
                    if (left > 0) {
                        minLen = Math.min(minLen, len + dp[left - 1]);
                    }
                }
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return minLen >= INF ? -1 : minLen;
    }
}
