package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LeetCode791
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/16 11:43
 * @Version 1.0
 */
public class LeetCode791 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                for (Integer integer = 0; integer < map.get(c); integer++) {
                    str.append(c);
                }
                map.remove(c);
            }
        }
        Set<Character> set = map.keySet();
        for (Character character : set) {
            for (Integer integer = 0; integer < map.get(character); integer++) {
                str.append(character);
            }
        }
        return str.toString();
    }

    public String customSortString1(String S, String T) {
        int[] count = new int[26];
        for (char c: T.toCharArray())
            count[c - 'a']++;
        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            count[c - 'a'] = 0;
        }
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode791 leetCode791 = new LeetCode791();
        System.out.println(leetCode791.customSortString1("cbafg", "abcd"));
    }
}
