package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode1331
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/28 9:47
 * @Version 1.0
 */
public class LeetCode1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] c = arr.clone();
        Arrays.sort(c);
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i : c) {
            if (!map.containsKey(i)) {
                map.put(i, ++j);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            c[i] = map.get(arr[i]);
        }
        return c;
    }
}
