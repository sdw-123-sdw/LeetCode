package leetcode;

import java.util.concurrent.Callable;

/**
 * @ClassName LeetCode392
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/26 20:57
 * @Version 1.0
 */
public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        int sl = 0;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        for (int i = 0; i < t.length(); i++) {
            if (chars2[i] == chars1[sl]) {
                if (sl == chars1.length - 1) return true;
                ++sl;
            }
        }
        return false;
    }
}