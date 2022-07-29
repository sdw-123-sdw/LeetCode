package leetcode;

/**
 * @ClassName leetcode.LeetCode29
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/12 16:29
 * @Version 1.0
 */
public class LeetCode29 {
    public static int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if(dividend == (-divisor)) return -1;
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(dividend == -2147483648 && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == -1) return -dividend;
        long count = 0;
        int fu = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            fu = -1;
        }
        dividend = Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int i = dividend;
        while (Math.abs(i) >= Math.abs(divisor)) {
            count++;
            dividend = i;
            i = dividend ^ divisor;
            dividend = dividend & divisor;
            while (true) {
                if (dividend == 0) {
                    break;
                }
                dividend = dividend << 1;
                int i1 = i;
                i = dividend ^ i;
                dividend = dividend & i1;
            }
        }
        return count * fu > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)(count * fu);
    }

//    public static int divide2(int dividend, int divisor) {
//
//    }

    public static void main(String[] args) {
//        System.out.println(divide(2147483647, 2));
        System.out.println((divide((7 >> 1), 2) << 1));
    }
}