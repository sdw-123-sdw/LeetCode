package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName LeetCode2221
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/28 10:07
 * @Version 1.0
 */
public class LeetCode2221 {
    public int triangularSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length - 1; i++) {
            queue.offer((nums[i] + nums[i + 1]) % 10);
        }
        queue.offer(-1);
        while (!queue.isEmpty()) {
            Integer p1 = queue.poll();
            sum = p1;
            Integer p2 = queue.peek();
            if (queue.size() == 1 && p2 == -1) break;
            if (p2 == -1) {
                queue.poll();
                queue.offer(-1);
                continue;
            }
            queue.offer((p1 + p2) % 10);
        }
        return sum;
    }

    public int triangularSum1(int[] nums) {
        return find(nums,nums.length);
    }

    public int find(int[] a, int n){
        if(n == 1)
            return a[0];

        for(int i=0;i<n-1;i++){
            a[i] = (a[i] + a[i+1])%10;
        }
        return find(a,n-1);
    }

    public static void main(String[] args) {
        LeetCode2221 leetCode2221 = new LeetCode2221();
        System.out.println(leetCode2221.triangularSum(new int[]{1, 2, 3, 4, 5}));
    }
}
