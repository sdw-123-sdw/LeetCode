package leetcode;

/**
 * @ClassName LeetCode1052
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/30 17:18
 * @Version 1.0
 */
public class LeetCode1052 {
    // 待修改
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        if (customers.length == 1) return customers[0];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) sum += customers[i];
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) sum += customers[i];
        }
        max = sum;
        for (end = minutes; end < customers.length; end++, start++) {
            if (grumpy[start] == 1) sum -= customers[start];
            if (grumpy[end] == 1) sum += customers[end];
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < minutes; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = minutes; i < n; i++) {
            increase = increase - customers[i - minutes] * grumpy[i - minutes] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }

    public static void main(String[] args) {
        LeetCode1052 leetCode1052 = new LeetCode1052();
        System.out.println(leetCode1052.maxSatisfied(new int[]{5, 8}, new int[]{0, 1}, 1));
    }
}
