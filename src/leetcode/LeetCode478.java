package leetcode;

import java.util.Random;

/**
 * @ClassName LeetCode478
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/5 10:31
 * @Version 1.0
 */
public class LeetCode478 {
    double xy;
    double yy;
    Random random = new Random();
    double r;
    public LeetCode478(double radius, double x_center, double y_center) {
        this.xy = x_center;
        this.yy = y_center;
        this.r = radius;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if (x * x + y * y <= r * r) {
                return new double[]{xy + x, yy + y};
            }
        }
    }
}
