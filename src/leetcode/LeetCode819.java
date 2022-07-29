package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode819
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/17 10:19
 * @Version 1.0
 */
public class LeetCode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        char[] chars = paragraph.toCharArray();
        Map<String, Integer> map = new HashMap();
        int length = chars.length;
        int j = 0;
        String max = null;
        for (int i = 0; i < length; ) {
            if (!Character.isLetter(chars[i])) { // 用于判断是否为字母
                i++;
                continue;
            }
            j = i + 1;
            while (j < length && Character.isLetter(chars[j])) j++;
            String substring = paragraph.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(substring)) continue;
            map.put(substring, map.getOrDefault(substring, 0) + 1);
            if (max == null || (map.get(max) < map.get(substring))) max = substring;
        }
        return max;
    }
}
