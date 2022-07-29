package leetcode.jianzhier;

/**
 * @ClassName LeetCode_jianzhier_024
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/19 9:59
 * @Version 1.0
 */
public class LeetCode_jianzhier_024 {
    public ListNode reverseList(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = null;
        while (l1 != null) {
            ListNode n = l1.next;
            l1.next = l2;
            l2 = l1;
            l1 = n;
        }
        return l2;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
