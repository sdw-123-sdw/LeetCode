package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode1200
 * @Description TODOl
 * @Author: 索德文
 * @date 2022/7/4 9:06
 * @Version 1.0
 */
public class LeetCode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int max = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            int flag = arr[i] - arr[i - 1];
            if (flag < max) {
                max = flag;
                list = new ArrayList<>();
            } else if (flag > max) {
                continue;
            }
            List<Integer> lists = new ArrayList<>();
            lists.add(arr[i - 1]);
            lists.add(arr[i]);
            list.add(lists);
        }
        return list;
    }
}
