package leetcode;

import java.util.Arrays;

/**
 * @ClassName leetcode.LeetCode66
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/21 15:48
 * @Version 1.0
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length - 1] < 9) {
            digits[digits.length - 1] += 1;
            return digits;
        } else if(Arrays.stream(digits).min().getAsInt() != 9) {
            digits[digits.length - 1] += 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if(digits[i] == 10) {
                    digits[i] = 0;
                    digits[i - 1] += 1;
                }
            }
            return digits;
        } else {
            int[] digits1 = new int[digits.length + 1];
            digits1[0] = 1;
            for (int i = 1; i < digits1.length; i++) {
                digits1[i] = 0;
            }
            return digits1;
        }
    }

    public static void main(String[] args) {
        LeetCode66 leetCode66 = new LeetCode66();
        int[] ints = {1,2,3};
//        String s = Arrays.toString(ints).replaceAll("\\[|\\]|,|\\s", "");
//        System.out.println(Integer.parseInt(s));
//        System.out.println(Integer.getInteger(ints.toString()));
//        System.out.println(leetCode66.plusOne(ints).);
    }
}
