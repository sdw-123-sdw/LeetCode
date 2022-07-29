package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode_interview_16_21
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/19 21:26
 * @Version 1.0
 */
public class LeetCode_interview_16_21 {
    // 暴力
    // 奇数-奇数=偶数
    // 偶数-偶数=偶数
    // 规律：两和相减必须为偶数，两个交换的数相减=两和相减/2
    // 两束相加也必须为偶数
    // 小值 + abs = 大值
    public int[] findSwapValues(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();
        int sum1 = 0;
        for (int i : array1) {
            sum1 += i;
            set.add(i);
        }
        int sum2 = 0;
        for (int i : array2) {
            sum2 += i;
        }
        int abs = Math.abs(sum1 - sum2);
        if (abs == 1) return new int[]{};
        abs = abs >> 1;
        for (int i : array2) {
            int j = i + abs;
            int k = i - abs;
            if (set.contains(j)) {
                return new int[]{j, i};
            }
            if (set.contains(k)) {
                return new int[]{k, i};
            }
        }
        return new int[0];
    }
}
