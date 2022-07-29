package leetcode;

/**
 * @ClassName leetcode.DoubleSum
 * @Description TODO
 * @Author: 索德文
 * @date 2021/6/1 8:22
 * @Version 1.0
 */


//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class DoubleSum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long sum = 0;
//        long i = 1;
//        leetcode.ListNode listNode = new leetcode.ListNode(0);
//        leetcode.ListNode listNode1 = listNode;
//        while(true) {
//            if (l1 != null || l2 != null) {
//                if(l1 == null) {
//                    sum = sum + l2.val * i;
//                    l2 = l2.next;
//                    i = i * 10;
//                    continue;
//                }
//                if(l2 == null) {
//                    sum = sum + l1.val * i;
//                    l1 = l1.next;
//                    i = i * 10;
//                    continue;
//                }
//                sum = sum + (long) (l1.val + l2.val) * i;
//                l1 = l1.next;
//                l2 = l2.next;
//                i = i * 10;
//            } else {
//                break;
//            }
//        }
//        while(true) {
//            if(sum < 10) {
//                return new leetcode.ListNode((int)sum, null);
//            }
//            leetcode.ListNode listNode2 = new leetcode.ListNode((int)(sum % 10));
//            sum = sum / 10;
//            listNode1.next = listNode2;
//            listNode1 = listNode2;
//            if(sum < 10) {
//                leetcode.ListNode listNode3 = new leetcode.ListNode((int)sum, null);
//                listNode1.next = listNode3;
//                break;
//            }
//        }
//        leetcode.ListNode listNode2 = new leetcode.ListNode();
//        listNode2 = listNode.next;
//        return listNode2;
        int sum = 0;
        ListNode listNode = new ListNode();
        ListNode listNode1 = listNode;
        int jinwei = 0;
        int ll1 = 0;
        int ll2 = 0;
        while(l1 != null || l2 != null || jinwei != 0) {
            if(l1 != null) {
                ll1 = l1.val;
            } else ll1 = 0;
            if(l2 != null) {
                ll2 = l2.val;
            } else ll2 = 0;
            sum = ll1 + ll2 + jinwei;
            jinwei = sum / 10;

            ListNode listNode2 = new ListNode(sum % 10);
            listNode1.next = listNode2;
            listNode1 = listNode2;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        ListNode listNode2 = new ListNode();
        listNode2 = listNode.next;
        return listNode2;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode())))))))));
        ListNode listNode1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        ListNode listNode2 = addTwoNumbers(listNode, listNode1);
        while (true) {
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
            if(listNode2 == null) {
                break;
            }
        }
    }
}
