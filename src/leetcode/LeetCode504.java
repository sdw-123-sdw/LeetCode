package leetcode;

/**
 * @ClassName LeetCode504
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/7 10:09
 * @Version 1.0
 */
public class LeetCode504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean c = num < 0;
        if (c) num = -num;
        while (num != 0) {
            int flag = num % 7;
            stringBuilder.append(flag);
            num = num / 7;
        }
        StringBuilder reverse = stringBuilder.reverse();// 字符串翻转
        return c ? '-' + reverse.toString() : reverse.toString();
    }

    public String convertToBase7_1(int num) {
        return Integer.toString(num, 7);
    }

    public static void main(String[] args) {
        LeetCode504 leetCode504 = new LeetCode504();
        System.out.println(leetCode504.convertToBase7(0));
    }
}
