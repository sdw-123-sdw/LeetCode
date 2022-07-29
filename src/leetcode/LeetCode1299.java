package leetcode;

/**
 * @ClassName LeetCode1299
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/11 10:37
 * @Version 1.0
 */
public class LeetCode1299 {
    // 可以逆序遍历
    public int[] replaceElements(int[] arr) {
        int l = arr.length;
        int[] ans = new int[l];
        ans[l - 1] = -1;
        int max = arr[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            ans[i] = max;
            max = Math.max(max, arr[i]);
        }
        return ans;
    }
}
