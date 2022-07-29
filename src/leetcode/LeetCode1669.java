package leetcode;

/**
 * @ClassName LeetCode1669
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/27 11:52
 * @Version 1.0
 */
public class LeetCode1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null;
        for (int i = 0; i <= a - 1; i++) {
            if (i == 0) {
                start = list1;
                continue;
            }
            start = start.next;
        }
        ListNode end = start.next;
        start.next = list2;
        for (int i = 0; i < b - a; i++) {
            end = end.next;
        }
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = end.next;
        return list1;
    }

    public static void main(String[] args) {
        LeetCode1669 leetCode1669 = new LeetCode1669();
        ListNode l1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        ListNode l2 = new ListNode(10000, new ListNode(10001, new ListNode(10002)));
        ListNode listNode = leetCode1669.mergeInBetween(l1, 3, 4, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
        }
    }
}
