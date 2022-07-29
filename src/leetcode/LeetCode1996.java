package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode1996
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/28 0:46
 * @Version 1.0
 */
public class LeetCode1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int count = 0;
        int max = -1;
        int n = properties.length;
        for (int i = 0; i < n; i++) {
            if (max > properties[i][1]) {
                count++;
            }
            max = Math.max(max, properties[i][1]);

        }
        return count;
    }
}
