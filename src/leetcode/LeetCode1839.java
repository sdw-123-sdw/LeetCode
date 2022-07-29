package leetcode;

/**
 * @ClassName LeetCode1839
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/24 10:05
 * @Version 1.0
 */
public class LeetCode1839 {
    public int longestBeautifulSubstring(String word) {
        if (word.length() < 5) return 0;
        int start = 0;
        int end = 1;
        int max = 0;
        int count = 1;
        char[] chars = word.toCharArray();
        int l = chars.length;
        for (; end < l; end++) {
            if (chars[end] != chars[end - 1]) ++count;
            if (chars[end] < chars[end - 1]) {
                --count;
                if (count == 5)
                    max = Math.max(max, end - start);
                start = end;
                count = 1;
                continue;
            }
            if (end == l - 1 && count == 5) {
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }
}
