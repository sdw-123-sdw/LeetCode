package leetcode;

import java.util.Stack;

/**
 * @ClassName leetcode.LeetCode495
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/10 9:13
 * @Version 1.0
 */
public class LeetCode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        Stack<Integer> stack = new Stack<>();
        int time = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (stack.empty()) {
                stack.push(timeSeries[i]);
            } else if (stack.peek() + duration > timeSeries[i]) {
                stack.add(timeSeries[i]);
            } else {
                int start = 0;
                int end = stack.peek();
                while (!stack.isEmpty()) {
                    start = stack.pop();
                }
                time += (end - start + duration);
                stack.push(timeSeries[i]);
            }
            if (i == timeSeries.length - 1) {
                int start = 0;
                int end = stack.peek();
                while (!stack.isEmpty()) {
                    start = stack.pop();
                }
                time += (end - start + duration);
            }
        }
        return time;
    }

    public int findPoisonedDuration1(int[] timeSeries, int duration) {
        int ans = 0;
        int prev = timeSeries[0];
        for(int i=1;i<timeSeries.length;i++){
            int cur = timeSeries[i];
            if(prev + duration-1 < cur){
                ans += duration;
            }else{
                ans += (cur - prev);
            }
            prev = cur;
        }
        ans += duration;
        return ans;
    }

    public static void main(String[] args) {
        LeetCode495 leetCode495 = new LeetCode495();
        System.out.println(leetCode495.findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
