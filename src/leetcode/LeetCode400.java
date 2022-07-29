package leetcode;

/**
 * @ClassName LeetCode400
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/30 16:04
 * @Version 1.0
 */
public class LeetCode400 {
    public int findNthDigit(int n) {
//        if (n <= 9) {
//            return n;
//        }
//        n = n - 9;
        long m = 9;
        int x = 1;
        n = n - (int)(m * x);
        while (n > 0 && m <= Integer.MAX_VALUE) {
            ++x;
            m *= 10;
            n = n - (int)(m * x);
        }
        n = n + (int) (m * x);
        int h = n / x;
        int t = 1;
        for (int i = 0; i < x - 2; i++) {
            t = t * 10;
        }
        if (n % x == 0) {
            return (int)(m / 10 + h - 1) % 10;
        }
        h = (int) m / 10 + h;
        m = m / 10;
        for (int i = 1; i < n % x; i++) {
            m = m / 10;
        }
        return (h / (int) m) % 10;
    }

    // 二分查找
    public int findNthDigit1(int n) {
        int left = 0;
        int right = n;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            long length = getAllLength(mid);
            if (length > n) {
                right = mid;
            } else if (length < n) {
                left = mid + 1;
            } else {
                left = mid;
                break;
            }
        }
        String s = String.valueOf(String.valueOf(left).charAt((int) (n - getAllLength(left - 1) - 1)));
        return Integer.parseInt(s);
    }

    private long getAllLength(int num) {
        long res = 0;
        String s = String.valueOf(num);
        for (int i = 1; i < s.length(); i++) {
            res += (Math.pow(10, i) - Math.pow(10, i - 1)) * i;
        }
        res += (num - Math.pow(10, s.length() - 1) + 1) * s.length();
        return res;
    }

    //
    int findNthDigit2(int n) {
        if (n < 10){
            return n;
        }
        long length = 0;
        long cnt = 9;
        long i = 1;
        for ( ; length + cnt * i < n; i++) {
            length += cnt * i;
            cnt *= 10;
        }
        long num = (long)Math.pow(10, i - 1) + (n - length - 1) / i;
        long index = (n - length - 1) % i;
        return String.valueOf(num).charAt((int)index) - '0';
    }
}
