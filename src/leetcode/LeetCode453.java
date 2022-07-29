package leetcode;

import java.util.Arrays;

/**
 * @ClassName leetcode.LeetCode453
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/21 17:42
 * @Version 1.0
 */
public class LeetCode453 {
    /*
    解题思路：每次n - 1个加一，其实就等价于1个数做减一操作，最后的结果其实就是原数组的和减去全部变成最小一个数后的和的差
     */
    public int minMoves(int[] nums) {
        return Arrays.stream(nums).sum() - (Arrays.stream(nums).min().getAsInt() * nums.length);
    }
    public int minMoves1(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            res += num;
        }
        return res - min * nums.length;
    }

    public static void main(String[] args) {
        LeetCode453 leetCode453 = new LeetCode453();
        System.out.println(leetCode453.minMoves(new int[]{1, 2, 3}));
    }
}
