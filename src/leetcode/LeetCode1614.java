package leetcode;

import java.util.Stack;

/**
 * @ClassName LeetCode1614
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/7 15:31
 * @Version 1.0
 */
public class LeetCode1614 {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ++count;
            } else if (s.charAt(i) == ')'){
                --count;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
