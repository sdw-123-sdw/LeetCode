package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName LeetCode71
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/6 11:30
 * @Version 1.0
 */
public class LeetCode71 {
    public String simplifyPath(String path) {
        Deque<String> d = new ArrayDeque<>();
        int n = path.length();
        for (int i = 1; i < n; ) {
            if (path.charAt(i) == '/' && ++i >= 0) continue;
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') j++;
            String item = path.substring(i, j);
            if (item.equals("..")) {
                if (!d.isEmpty()) d.pollLast();
            } else if (!item.equals(".")) {
                d.addLast(item);
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) sb.append("/" + d.pollFirst());
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
