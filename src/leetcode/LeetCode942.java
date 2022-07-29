package leetcode;

/**
 * @ClassName LeetCode942
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/9 10:44
 * @Version 1.0
 */
public class LeetCode942 {
    // 采用贪心算法
    public int[] diStringMatch(String s) {
        int l = s.length();
        int[] ints = new int[l + 1];
        int min = 0;
        int max = l;
        for (int i = 0; i < l; i++) {
            ints[i] = s.charAt(i) == 'I' ? min++ : max--;
        }
        ints[l] = min;
        return ints;
    }
}
