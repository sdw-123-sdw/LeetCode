package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LeetCode817
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/16 2:24
 * @Version 1.0
 */
public class LeetCode817 {
    // 所有值都不相同
    // 题目说的是在原链中相接
    // 返回的是组件的个数，不是最长组件的长度
    public int numComponents2(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        boolean flag = false;
        while (true) {
            if (head != null && set.contains(head.val)) {
                flag = true;
            } else {
                if (flag && head == null) {
                    count++;
                    break;
                }
                if (head == null) break;
                if (flag) count++;
                flag = false;
            }
            head = head.next;
        }
        return count;
    }


    // 以下两个方法都是返回最长组件的长度

    // 这个是在链表中相接
    public int numComponents1(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        int count = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                max = Math.max(max, ++count);
            } else {
                count = 0;
            }
            head = head.next;
        }
        return max;
    }


    // 这个是在nums中相接
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        int count = 0;
        int i = 0;
        boolean flag = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (head.val == nums[i]) {
                    flag = true;
                    max = Math.max(max, ++count);
                } else {
                    count = 0;
                    flag = false;
                }
                i++;
            } else {
                count = 0;
                flag = false;
            }
            head = head.next;
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode817 leetCode817 = new LeetCode817();
        ListNode l = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println(leetCode817.numComponents(l, new int[]{0, 3, 1, 4}));
    }
}
