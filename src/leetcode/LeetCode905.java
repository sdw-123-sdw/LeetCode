package leetcode;

/**
 * @ClassName LeetCode905
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/28 10:30
 * @Version 1.0
 */
public class LeetCode905 {
    public int[] sortArrayByParity(int[] nums) {
        int l = nums.length;
        if (l == 1) return nums;
        int start = 0;
        int end = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] % 2 != 0) {
                start = i;
                end = start;
                break;
            }
            if (i == l - 1) {
                return nums;
            }
        }
        for (; end < l; end++) {
            if (nums[end] % 2 == 0) {
                nums[start] = nums[start] ^ nums[end];
                nums[end] = nums[start] ^ nums[end];
                nums[start] = nums[start] ^ nums[end];
                ++start;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode905 leetCode905 = new LeetCode905();
        int[] ints = leetCode905.sortArrayByParity(new int[]{0, 2});
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
