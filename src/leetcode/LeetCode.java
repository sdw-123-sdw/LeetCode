package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/19 9:53
 * @Version 1.0
 */
public class LeetCode {
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] returns = new int[length];
        Arrays.fill(returns, length + 1);
        for (int i = 0, j = -1; i < length; i++) {
            if (chars[i] == c) j = i;
            if (j != -1) returns[i] = i - j;
        }
        for (int i = length - 1, j = -1; i >= 0; i--) {
            if (chars[i] == c) j = i;
            if (j != -1) returns[i] = Math.min(returns[i], j - i);
        }
        return returns;
    }
}
