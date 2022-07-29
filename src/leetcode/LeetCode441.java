package leetcode;

/**
 * @ClassName leetcode.LeetCode441
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/10 10:30
 * @Version 1.0
 */
public class LeetCode441 {
    public static int arrangeCoins(int n) {
        System.out.println(Math.sqrt(1 + 8 * (long) n));
        return (int) (-1 + Math.sqrt(1 + 8 * (long) n)) / 2;
    }

    public static int arrangeCoins3(int n) {
        long start = 0, end = (long) n / 2 + 1, mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }

    public static void main(String[] args) {
//        System.out.println(arrangeCoins(21));
//        System.out.println(3 >> 1);
        System.out.println(arrangeCoins3(5));
    }
}
