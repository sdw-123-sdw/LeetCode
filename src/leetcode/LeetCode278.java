package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode278
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/14 8:56
 * @Version 1.0
 */
public class LeetCode278 {
    static List<Integer> list = new ArrayList<>();
    static int[] hash = new int[10010];
    static {
        for (int i = 1; i <= 10000; i++) {
            int cur = i;
            boolean ok = true;
            while (cur != 0 && ok) {
                int u = cur % 10;
                if (u == 0 || i % u != 0) ok = false;
                cur /= 10;
            }
            if (ok) list.add(i);
            hash[i] = list.size() - 1;
        }
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        int idx = list.get(hash[left]) == left ? hash[left] : hash[left] + 1;
        while (idx < list.size() && list.get(idx) <= right) ans.add(list.get(idx++));
        return ans;
    }
}
