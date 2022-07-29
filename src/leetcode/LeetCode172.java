package leetcode;

/**
 * @ClassName LeetCode172
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/25 22:33
 * @Version 1.0
 */
public class LeetCode172 {
    long m = 1;
    public int trailingZeroes(int n) {
        if (n == 1 || n == 0) return 0;
        swap(n);
        n = 0;
        System.out.println(m);
        while (m % 10 == 0) {
            ++n;
            m /= 10;
        }
        return n;
    }

    private void swap(int n) {
        if (n == 1) return;
        m = m * n;
        swap(n - 1);
    }

    /*
    对于任意一个 n! 而言，其尾随零的个数取决于展开式中 10 的个数，而 10 可由质因数 2 * 5 而来，因此 n! 的尾随零个数为展开式中各项分解质因数后「2的数量」和「5的数量」中的较小值。
    https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/by-ac_oier-1y6w/
     */
    public int trailingZeroes2(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes2(n / 5);
    }

    public static void main(String[] args) {
        LeetCode172 leetCode172 = new LeetCode172();
        System.out.println(leetCode172.trailingZeroes(30));
    }
}
