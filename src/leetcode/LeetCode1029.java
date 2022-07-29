package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName LeetCode1029
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/27 8:55
 * @Version 1.0
 */
public class LeetCode1029 {
    public int twoCitySchedCost(int[][] costs) {
        int l = costs.length;
        List<Integer> aCost = new ArrayList<>();
        List<Integer> bCost = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            int abs = costs[i][0] - costs[i][1];
            if (abs <= 0) {
                sum += costs[i][0];
                aCost.add(-abs);
            } else {
                sum += costs[i][1];
                bCost.add(abs);
            }
        }
        int a = aCost.size();
        int b = bCost.size();
        if (a < b) {
            bCost.sort((o1, o2) -> o1 - o2);
            while (a != b) {
                sum += bCost.remove(0);
                b--;
                a++;
            }
        } else if (a > b){
            aCost.sort((o1, o2) -> o1 - o2);
            while (a != b) {
                sum += aCost.remove(0);
                a--;
                b++;
            }
        }
        return sum;
    }

    // 全部去b，然后让差值最小的去a（可能为负数）
    public int twoCitySchedCost2(int[][] costs) {
        // Sort by a gain which company has
        // by sending a person to city A and not to city B
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length / 2;
        // To optimize the company expenses,
        // send the first n persons to the city A
        // and the others to the city B
        for (int i = 0; i < n; ++i) total += costs[i][0] + costs[i + n][1];
        return total;
    }

    public static void main(String[] args) {
        LeetCode1029 leetCode1029 = new LeetCode1029();
        System.out.println(leetCode1029.twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}));
    }
}
