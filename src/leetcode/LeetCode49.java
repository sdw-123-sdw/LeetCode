package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode49
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/7 12:35
 * @Version 1.0
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int l = strs.length;
        Map<String, Integer> map = new HashMap();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            System.out.println(s);
            if (map.containsKey(s)) {
                list.get(map.get(s)).add(strs[i]);
            } else {
                List<String> list1 = new ArrayList<>();
                list1.add(strs[i]);
                list.add(list1);
                map.put(s, list.size() - 1);
            }
        }
        return list;
    }
}
