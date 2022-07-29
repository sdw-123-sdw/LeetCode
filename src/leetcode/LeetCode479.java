package leetcode;

/**
 * @ClassName LeetCode479
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/16 16:14
 * @Version 1.0
 */
public class LeetCode479 {
    // 利用枚举方法，进行回文数的构造，然后找出可除数
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        // 10的n次
        int max = (int) Math.pow(10, n) - 1;
        for (int i = max; i >= 0; i--) {
            long num = i, t = i;
            // 构造最大回文数字
            while (t != 0) {
                num = num * 10 + (t % 10);
                t /= 10;
            }
            // 寻找是否有可以整除的数
            // 至于为什么是平方，因为是从大向小找的，所以此处的被除数肯定是大的，若是平方小了，那么说明被除数是小的了
            for (long j = max; j * j >= num; j--) {
                if (num % j == 0) return (int)(num % 1337);
            }
        }
        return -1;
    }
}
