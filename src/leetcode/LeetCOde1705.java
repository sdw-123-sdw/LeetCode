package leetcode;

import sun.applet.Main;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName LeetCOde1705
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/24 9:47
 * @Version 1.0
 */
public class LeetCOde1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int n = apples.length, time = 0, ans = 0;
        while (time < n || !q.isEmpty()) {
            if (time < n && apples[time] > 0) q.add(new int[]{time + days[time] - 1, apples[time]});
            while (!q.isEmpty() && q.peek()[0] < time) q.poll();
            if (!q.isEmpty()) {
                int[] cur = q.poll();
                if (--cur[1] > 0 && cur[0] > time) q.add(cur);
                ans++;
            }
            time++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCOde1705 leetCOde1705 = new LeetCOde1705();
        System.out.println(leetCOde1705.eatenApples(new int[]{2,1,1,4,5}, new int[]{10,10,6,4,2}));
    }
}

class Comparators implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
}
