package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LeetCode929
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/4 22:21
 * @Version 1.0
 */
public class LeetCode929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            int i = split[0].indexOf("+");
            String swap;
            if (i < 0) {
                swap = swap(split[0]);
            } else {
                swap = swap(split[0].substring(0, i));
            }
            set.add(swap + "@" + split[1]);
        }
        return set.size();
    }

    private String swap(String split) {
        StringBuilder s = new StringBuilder();
        for (int i1 = 0; i1 < split.length(); i1++) {
            char c = split.charAt(i1);
            if (c == '.') {
                continue;
            }
            s.append(c);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String[] s = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        LeetCode929 leetCode929 = new LeetCode929();
        System.out.println(leetCode929.numUniqueEmails(s));
    }
}
