package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName LeetCode385
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/15 18:48
 * @Version 1.0
 */
public class LeetCode385 {
    // 利用单调栈
//    static NestedInteger ph = new NestedInteger(0);
//    public NestedInteger deserialize(String s) {
//        Deque<NestedInteger> d = new ArrayDeque<>();
//        char[] cs = s.toCharArray();
//        int n = cs.length, i = 0;
//        while (i < n) {
//            if (cs[i] == ',' && ++i >= 0) continue;
//            if (cs[i] == '-' || (cs[i] >= '0' && cs[i] <= '9')) {
//                int j = cs[i] == '-' ? i + 1 : i, num = 0;
//                while (j < n && (cs[j] >= '0' && cs[j] <= '9')) num = num * 10 + (cs[j++] - '0');
//                d.addLast(new NestedInteger(cs[i] == '-' ? -num : num));
//                i = j;
//            } else if (cs[i] == '[') {
//                d.addLast(new NestedInteger());
//                d.addLast(ph);
//                i++;
//            } else {
//                List<NestedInteger> list = new ArrayList<>();
//                while (!d.isEmpty()) {
//                    NestedInteger poll = d.pollLast();
//                    if (poll == ph) break;
//                    list.add(poll);
//                }
//                for (int j = list.size() - 1; j >= 0; j--) d.peekLast().add(list.get(j));
//                i++;
//            }
//        }
//        return d.peekLast();
//    }
}
