package leetcode;

/**
 * @ClassName LeetCode396
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/22 9:22
 * @Version 1.0
 */
public class LeetCode396 {
    // 暴力，超时
    public int maxRotateFunction(int[] nums) {
        int length = nums.length;
        if (length == 1) return 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            max += (i * nums[i]);
        }
        for (int i = 1; i < length; i++) {
            int i1 = length - i;
            int f = 0;
            int j = (i1 + 1) % length;
            for (int z = 1; j != i1; z++) {
                f += (z * nums[j]);
                ++j;
                j = j % length;
            }
            max = Math.max(max, f);
        }
        return max;
    }

    // 前缀和 + 滑动窗口
    public int maxRotateFunction2(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n * 2 + 10];
        for (int i = 1; i <= 2 * n; i++) sum[i] = sum[i - 1] + nums[(i - 1) % n];
        int ans = 0;
        for (int i = 1; i <= n; i++) ans += nums[i - 1] * (i - 1);
        for (int i = n + 1, cur = ans; i < 2 * n; i++) {
            cur += nums[(i - 1) % n] * (n - 1);
            cur -= sum[i - 1] - sum[i - n];
            if (cur > ans) ans = cur;
        }
        return ans;
    }

    // 数学推导
    /*
    F[0] = nums[0] * 0 + ... + (n - 1) * nums[n - 1]
    F[1] = nums[n - 1] * 0 + ... + (n - 1) * nums[n - 2]
    F[1] - F[0] = nums[0] + ... + nums[n - 2] - (n - 1) * nums[n - 1]
    F[1] = F[0] + Sum{nums[i]} - n * nums[n - 1]
    同理可以进行推导
    F[i] = F[i-1] + Sum{nums[i]} - n * nums[n - i]
     */
    public int maxRotateFunction3(int[] nums) {
        int sum = 0;
        int o = 0;
        int n = nums.length;
        // 初始化 sum 和 F[0] = o
        for(int i = 0;i < n;i ++) {
            o += nums[i] * i;
            sum += nums[i];
        }
        int res = o;
        // F[i] = F[i-1] + sum - n * nums[n - i]
        for(int i = 1;i < n;i ++) {
            o = o + sum - n * nums[n - i];
            res = Math.max(res,o);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode396 leetCode396 = new LeetCode396();
        System.out.println(leetCode396.maxRotateFunction(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
