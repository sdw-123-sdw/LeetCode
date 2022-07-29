package leetcode;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @ClassName LeetCode2095
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/27 9:40
 * @Version 1.0
 */
public class LeetCode2095 {
    boolean flag = false;
    public ListNode deleteMiddle(ListNode head) {
        swap(head, -1);
        return flag ? null : head;
    }

    private int swap(ListNode root, int count) {
        if (root == null) return count + 1;
        count++;
        int swap = swap(root.next, count);
        if ((swap >> 1) == count) {
            flag = true;
            return swap;
        }
        if (flag) {
            root.next = root.next.next;
            flag = false;
            return swap;
        }
        return swap;
    }

    public ListNode deleteMiddle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head.next == null) {
            return null;
        }
        while(true){
            if(fast.next.next == null || fast.next.next.next == null) {
                //短路或，只要前面是true就不会往后判断
                slow.next = slow.next.next;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return head;
    }
}
