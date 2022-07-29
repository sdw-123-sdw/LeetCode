package leetcode;

/**
 * @ClassName LeetCode1446
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/1 9:42
 * @Version 1.0
 */
public class LeetCode1446 {
    public int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int m = 0;
        int max = 0;
        int i;
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(m) != s.charAt(i)) {
                max = Math.max(max, i - m);
                m = i;
            }
        }
        return Math.max(max, i - m);
    }
}
