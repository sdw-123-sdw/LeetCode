package leetcode;

/**
 * @ClassName LeetCode50
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/16 21:23
 * @Version 1.0
 */
public class LeetCode50 {
    public double myPow(double x, int n) {
        long y = n;
        return n > 0 ? swap(x, y) : 1.0 / swap(x, -y);
    }

    /**
     *
     * @param x 基数
     * @param y 目前的倍数
     */
    private double swap(double x, long y) {
        if (y == 0) return 1.0;
        double z = swap(x, y >> 1);
        return (y & 1) == 1 ? z * z * x : z * z;
    }
}
