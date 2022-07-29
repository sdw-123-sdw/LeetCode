package leetcode;

/**
 * @ClassName LeetCode1734
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/10 11:21
 * @Version 1.0
 */
public class LeetCode1734 {
    /*
    encoded隔位亦或可以得到ans从0到n-2的亦或序列
    然后再利用是前n位正整数的排列，可以得到ans从0到n-1的亦或序列
    两个结果进行亦或就能得到ans的n-1的值，然后依次往前运算即可
     */
    public int[] decode(int[] encoded) {
        int l = encoded.length + 1;
        int[] ans = new int[l];
        int a = 0;
        for (int i = 0; i < l - 1; i += 2) {
            a ^= encoded[i];
        }
        int b = 0;
        for (int i = 1; i <= l; i++) {
            b ^= i;
        }
        ans[l - 1] = a ^ b;
        for (int i = l - 2; i >= 0; i--) {
            ans[i] = encoded[i] ^ ans[i + 1];
        }
        return ans;
    }
}
