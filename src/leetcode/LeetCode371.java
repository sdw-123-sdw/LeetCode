package leetcode;

/**
 * @ClassName leetcode.LeetCode371
 * @Description TODO
 * @Author: 索德文
 * @date 2021/9/27 21:34
 * @Version 1.0
 */
public class LeetCode371 {
    public int getSum(int a, int b) {
        int i = a ^ b;
        int i1 = a & b;
        int i2 = i;
        while (true) {
            if(i1 == 0) {
                i = i2;
                break;
            }
            i1 = i1 << 1;
            i = i2;
            i2 = i2 ^ i1;
            i1 = i & i1;
        }
        return i;
    }

    public int getSum2(int a, int b) {
        while ((a & b) != 0) {
            // 进位
            int t = (a & b) << 1;
            // 找出无需进位的点，相加
            b = a ^ b;
            a = t;
        }
        return a ^ b;
    }

    public int getSum3(int a, int b) {
        /**
         * pow(a, b):以a为底的b次幂
         */
        double x = Math.pow(10, a);
        double y = Math.pow(10, b);

        return (int) Math.log10(x * y);
    }

    public int getSum4(int a, int b) {
        /**
         * exp(a):以e为底的a次幂
         */
        return (int)Math.log(Math.exp(a) * Math.exp(b));
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(-1));
        LeetCode371 leetCode371 = new LeetCode371();
//        System.out.println(leetCode371.getSum(1, -3));
        System.out.println(leetCode371.getSum3(9, -3));
    }
}
