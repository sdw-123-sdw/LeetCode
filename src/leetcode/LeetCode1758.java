package leetcode;

/**
 * @ClassName LeetCode1758
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/19 16:36
 * @Version 1.0
 */
public class LeetCode1758 {
    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        int start0 = 0;
        int start1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                if (chars[i] == '1') {
                    start0++;
                } else {
                    start1++;
                }
            } else {
                if (chars[i] == '1') {
                    start1++;
                } else {
                    start0++;
                }
            }
        }
        return Math.min(start0, start1);
    }
}
