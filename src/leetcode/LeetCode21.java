package leetcode;

/**
 * @ClassName leetcode.LeetCode21
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/21 21:35
 * @Version 1.0
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return l1;
        } else if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }

        ListNode node = l1;
        ListNode node1 = l1;
        while (node != null && l2 != null) {
            if (node.val <= l2.val) {
                node = node.next;
                l1.next = l2;
                l1 = l2;
            } else {
                l2 = l2.next;
                l1.next = node;
                l1 = node;
            }
        }

        if(node == null) {
            l1.next = l2;
        } else if(l2 == null){
            l1.next = node;
        }

        return node1;
    }

    public static void main(String[] args) {
        LeetCode21 leetCode21 = new LeetCode21();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode = leetCode21.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}