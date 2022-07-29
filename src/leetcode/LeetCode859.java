package leetcode;

import java.util.HashSet;

/**
 * @ClassName leetcode.LeetCode859
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/23 8:44
 * @Version 1.0
 */
public class LeetCode859 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        int start = -1;
        int end = -1;
        HashSet<Character> stack = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            flag = flag ? stack.add(s.charAt(i)) : false;
            if(s.charAt(i) != goal.charAt(i)) {
                if(start == -1) {
                    start = i;
                    continue;
                }
                if(end != -1) {
                    return false;
                }
                end = i;
            }
        }
        if(start != -1 && end != -1
                && s.charAt(start) == goal.charAt(end)
                && s.charAt(end) == goal.charAt(start)) {
            return true;
        } else if(start == -1 && end == -1 && !flag) {
            return true;
        }
        return false;
    }
    public boolean buddyStrings1(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        } else if(s.equals(goal)) {
            if(s.length() > 26) {
                return true;
            }
            int[] ints = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if(ints[s.charAt(i) - 'a'] != 0) {
                    return true;
                }
                ints[s.charAt(i) - 'a']++;
            }
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                if(start == -1) {
                    start = i;
                    continue;
                }
                if(end != -1) {
                    return false;
                }
                end = i;
            }
        }
        if(start != -1 && end != -1 && s.charAt(start) == goal.charAt(end) && s.charAt(end) == goal.charAt(start)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode859 leetCode859 = new LeetCode859();
        System.out.println(leetCode859.buddyStrings1("aaab", "aaab"));
    }
}
