package leetcode;

/**
 * @ClassName LeetCode1422
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/26 17:46
 * @Version 1.0
 */
public class LeetCode1422 {
    public int maxScore(String s) {
        int max = 0;
        int num0 = 0;
        int num1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                num1++;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                num0++;
            } else {
                num1--;
            }
            max = Math.max(num0 + num1, max);
        }
        return max;
    }

    public int maxScore2(String s) {
        char[] chs = s.toCharArray();
        int sorce = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '1') {
                sorce++;
            }
        }
        int max_sum = 0;
        for (int i = 0; i < chs.length - 1; i++) {
            if (chs[i] == '0') {
                sorce++;
            } else {
                sorce--;
            }
            max_sum = Math.max(max_sum, sorce);
        }
        return max_sum;
    }
}
