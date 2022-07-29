package leetcode;

/**
 * @ClassName leetcode.LeetCode476
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/18 8:48
 * @Version 1.0
 */
public class LeetCode476 {
    public int findComplement(int num) {
        int m = num;
        int c = 0;
        while (m > 0) {
            m = m >> 1;
            c = (c << 1) + 1;
        }
        return num ^ (c);
    }

    public static void main(String[] args) {
        LeetCode476 leetCode476 = new LeetCode476();
        System.out.println(leetCode476.findComplement(1));
//        System.out.println(Integer.hashCode(-1));
//        System.out.println(Integer.toBinaryString(-1));
    }
}
