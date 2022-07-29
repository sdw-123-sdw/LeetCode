package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode969
 * @Description TODO
 * @Author: 索德文
 * @date 2022/2/19 1:31
 * @Version 1.0
 */
public class LeetCode969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int n = arr.length; n > 1; n--) {
            int index = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] >= arr[index]) {
                    index = i;
                }
            }
            if (index == n - 1) {
                continue;
            }
            for (int i = 0, j = index; i < j; i++, j--) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
            ret.add(index + 1);
            ret.add(n);
        }
        return ret;
    }
}
