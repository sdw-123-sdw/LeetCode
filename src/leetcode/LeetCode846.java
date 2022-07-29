package leetcode;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName LeetCode846
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/30 14:30
 * @Version 1.0
 */
public class LeetCode846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->a-b);
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            q.add(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            if (map.get(t) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int cnt = map.getOrDefault(t + i, 0);
                if (cnt == 0) return false;
                map.put(t + i, cnt - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode846 leetCode846 = new LeetCode846();
        System.out.println(leetCode846.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }
}
