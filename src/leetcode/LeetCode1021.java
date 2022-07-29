package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName LeetCode1021
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/28 9:48
 * @Version 1.0
 */
public class LeetCode1021 {
    public String removeOuterParentheses(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ')') {
                i--;
            }
            if (i > 0) {
                sb.append(aChar);
            }
            if (aChar == '(') {
                i++;
            }
        }
        return sb.toString();
    }

    public String removeOuterParentheses1(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ')') {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                sb.append(aChar);
            }
            if (aChar == '(') {
                deque.push(aChar);
            }
        }
        return sb.toString();
    }
    public String removeOuterParentheses2(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, score = 0; i < n; ) {
            int j = i;
            while (i == j || score != 0) score += cs[j++] == '(' ? 1 : -1;
            sb.append(s.substring(i + 1, j - 1));
            i = j;
            score = 0;
        }
        return sb.toString();
    }
}
