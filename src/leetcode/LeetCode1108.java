package leetcode;

import java.util.Random;

/**
 * @ClassName LeetCode1108
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/21 8:44
 * @Version 1.0
 */
public class LeetCode1108 {
    public String defangIPaddr(String address) {
        // return address.replace(".", "[.]");  // 这种方法最好
        String[] split = address.split("\\.");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            s.append(split[i]);
            if (i != 3) {
                s.append("[.]");
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        LeetCode1108 leetCode1108 = new LeetCode1108();
        System.out.println(leetCode1108.defangIPaddr("1.1.1.1"));
        // int count = 0;
        // int N = 10_0000_0;
        // Random random = new Random();
        // for (int j = 0; j < N; j++) {
        //     double i1 = random.nextDouble();
        //     System.out.println(i1);
        //     if (i1 <= 0.16) {
        //         double i;
        //         do {
        //             i = random.nextDouble();
        //         }
        //         while (i >= 0.4);
        //         System.out.println(i);
        //         count++;
        //     } else {
        //         double i;
        //         do {
        //             i = random.nextDouble();
        //         }
        //         while (i < 0.4 && i > 0);
        //         System.out.println(i);
        //     }
        // }
        // System.out.println(count/1000000.0);
    }
}
