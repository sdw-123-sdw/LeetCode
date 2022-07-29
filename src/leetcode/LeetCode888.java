package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode888
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/10 10:43
 * @Version 1.0
 */
public class LeetCode888 {
    /*
    设a需要交换的数量为x；b需要交换的数量为y
    suma - x + y = sumb - y + x
    x = y + (suma - sumb) / 2
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int suma = 0;
        int sumb = 0;
        Set<Integer> set = new HashSet<>();
        for (int bobSize : bobSizes) {
            sumb += bobSize;
            set.add(bobSize);
        }
        suma = Arrays.stream(aliceSizes).sum();
        int i = (suma - sumb) >> 1;
        for (int aliceSize : aliceSizes) {
            if (set.contains(aliceSize - i)) {
                return new int[]{aliceSize, aliceSize - i};
            }
        }
        return null;
    }
}
