package leetcode;

/**
 * @ClassName LeetCode258
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/3 14:13
 * @Version 1.0
 */
public class LeetCode258 {
    public int addDigits(int num) {
        do {
            int returns  = 0;
            while (num != 0) {
                returns += num % 10;
                num = num / 10;
            }
            num = returns;
        } while (num > 9);
        return num;
    }

    public static void main(String[] args) {
        LeetCode258 leetCode258 = new LeetCode258();
        System.out.println(leetCode258.addDigits(0));
    }
}
