package leetcode;

import java.util.*;

/**
 * @ClassName leetcode.LeetCode496
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/26 8:44
 * @Version 1.0
 */
public class LeetCode496 {
    // 单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
