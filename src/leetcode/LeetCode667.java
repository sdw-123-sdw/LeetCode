package leetcode;

/**
 * @ClassName LeetCode667
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/7 11:46
 * @Version 1.0
 */
public class LeetCode667 {
    /**
     * 对于序列[1,n] 和 k，只需要从序列的首尾交替取k个数，然后按照最后一个数递增或递减。
     *
     * 例如n=9，k=5，我们只需要从序列的首尾交替取5个数即可。
     *
     * nums: 1,9,2,8,3
     * diff:  8,7,6,5
     * 现在已经有4个不同的相邻差，接下来的数自然递增可以了。
     *
     * nums: 1,9,2,8,3,4,5,6,7
     * diff:  8 7 6 5 1 1 1 1
     * 一共有且仅有5个不同的相邻差。
     *
     */
    public int[] constructArray(int n, int k) {
        int start = 1;
        int end = n;
        int[] ans = new int[n];
        for (int i = 0; i < k; i++) {
            if ((i & 1) == 0) {
                ans[i] = start;
                start++;
            } else {
                ans[i] = end;
                end--;
            }
        }
        if (n - end == start - 1) {
            while (end >= start) {
                ans[k] = end;
                end--;
                k++;
            }
        } else {
            while (end >= start) {
                ans[k] = start;
                start++;
                k++;
            }
        }
        return ans;
    }
}
