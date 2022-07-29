package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName LeetCode1610
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/16 11:02
 * @Version 1.0
 */
public class LeetCode1610 {
    // 只需要求数量即可
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> list = new ArrayList<>();
        int a = location.get(0);
        int b = location.get(1);
        double angles = 0;
        int count = 0;
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if (x == a && y == b) {
                ++count;
                continue;
            }
            list.add(((double) (y - b)) / (x - a));
        }
        Collections.sort(list);
        int counts = count;
        a = 0;
        b = 0;
        for (; b < list.size() && (list.get(b) - list.get(a)) <= angle; b++) {
            counts++;
        }
        count = Math.max(count, counts);
        while (b < list.size() && a < b) {
            while (list.get(a) == list.get(a + 1)) {
                a++;
                counts--;
            }
            a++;
//            list.get(b + 1) - list.get(a) <=

        }
        return count;
    }

    // 宫水三叶
    public int visiblePoints2(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0), y = location.get(1);
        List<Double> list = new ArrayList<>();
        int count = 0;
        double pi = Math.PI, t = angle * pi / 180;
        for (List<Integer> point : points) {
            int a = point.get(0), b = point.get(1);
            if (a == x && b == y) {
                ++count;
                continue;
            }
            list.add(Math.atan2(b - y, a - x) + pi);
        }
        Collections.sort(list);
        int n = list.size(), max = 0;
        for (int i = 0; i < n; i++) list.add(list.get(i) + 2 * pi);
        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t) i++;
            max = Math.max(max, j - i + 1);
        }
        return count + max;
    }
}
