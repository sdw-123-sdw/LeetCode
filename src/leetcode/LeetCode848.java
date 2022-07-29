package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode848
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/18 11:22
 * @Version 1.0
 */
public class LeetCode848 {
    // 简单倒叙题
    public String shiftingLetters(String s, int[] shifts) {
        int count = 0;
        char[] c = s.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--) {
            count = (count + shifts[i]) % 26;
            c[i] = (char) ('a' + ((c[i] - 'a' + count) % 26));
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        LeetCode848 leetCode848 = new LeetCode848();
        System.out.println(leetCode848.shiftingLetters("abc", new int[]{3, 5, 9}));
    }
}
