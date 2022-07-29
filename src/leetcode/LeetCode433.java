package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode433
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/7 11:01
 * @Version 1.0
 */
public class LeetCode433 {
    String S, T;
    Set<String> set = new HashSet<>();
    static char[] items = new char[]{'A','C','G','T'};
    public int minMutation(String _s, String _e, String[] bank) {
        S = _s; T = _e;
        for (String s : bank) set.add(s);
        return bfs();
    }
    int bfs() {
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        d1.addLast(S); m1.put(S, 0);
        d2.addLast(T); m2.put(T, 0);
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if (d1.size() <= d2.size()) t = update(d1, m1, m2);
            else t = update(d2, m2, m1);
            if (t != -1) return t;
        }
        return -1;
    }
    int update(Deque<String> d, Map<String, Integer> cur, Map<String, Integer> other) {
        int size = d.size();
        while (size-- > 0) {
            String s = d.pollFirst();
            char[] cs = s.toCharArray();
            int step = cur.get(s);
            for (int i = 0; i < 8; i++) {
                for (char c : items) {
                    if (cs[i] == c) continue;
                    char[] clone = cs.clone();
                    clone[i] = c;
                    String sub = String.valueOf(clone);
                    if (!set.contains(sub)) continue;
                    if (other.containsKey(sub)) return step + 1 + other.get(sub);
                    if (!cur.containsKey(sub) || cur.get(sub) > step + 1) {
                        cur.put(sub, step + 1);
                        d.addLast(sub);
                    }
                }
            }
        }
        return -1;
    }
}
