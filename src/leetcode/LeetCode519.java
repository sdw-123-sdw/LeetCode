package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leetcode.LeetCode519
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/27 10:16
 * @Version 1.0
 */

/**
 * 在解法一中，我们将二维问题转化为了一维问题。
 *
 * 起始时，我们只需要在 [0, m * n)[0,m∗n) 这连续一段的区间内进行随机，但当我们经过了多次翻转后，该区间内的某些位置会被断开，使得数组不再连续。
 *
 * 如果我们希望在每次随机时都采用起始的方式（在连续一段内进行随机），需要确保某些位置被翻转后，剩余位置仍是连续。
 *
 * 具体的，我们可以使用「哈希表」多记录一层映射关系：起始时所有位置未被翻转，我们规定未被翻转的位置其映射值为编号本身（idx = row * n + colidx=row∗n+col），由于未被翻转的部分具有等值映射关系，因此无须在哈希表中真实存储。当随机到某个位置 idxidx 时，进行分情况讨论：
 *
 * 该位置未被哈希表真实记录（未被翻转）：说明 idxidx 可被直接使用，使用 idxidx 作为本次随机点。同时将右端点（未被使用的）位置的映射值放到该位置，将右端点左移。确保下次再随机到 idxidx，仍能直接使用 idxidx 的映射值，同时维护了随机区间的连续性；
 * 该位置已被哈希表真实记录（已被翻转）：此时直接使用 idxidx 存储的映射值（上一次交换时的右端点映射值）即可，然后用新的右端点映射值将其进行覆盖，更新右端点。确保下次再随机到 idxidx，仍能直接使用 idxidx 的映射值，同时维护了随机区间的连续性。
 */
public class LeetCode519 {
    int m, n, num;
    Map<Integer, Integer> map;
    public LeetCode519(int m, int n) {
        this.m = m;
        this.n = n;
        num = m * n;
        map = new HashMap<>();
    }

    public int[] flip() {
        int a = (int)(num * Math.random());
        int b = a;
        num--;
        if(map.containsKey(a)) {
            b = map.get(a);
        }
        map.put(a, map.getOrDefault(num, num));
        return new int[]{b / n, b % n};
    }

    public void reset() {
        num = m * n;
        map = new HashMap<>();
    }
}
