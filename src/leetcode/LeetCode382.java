package leetcode;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.LinkedList;
import java.util.Random;

/**
 * @ClassName LeetCode382
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/16 9:22
 * @Version 1.0
 */
public class LeetCode382 {
    ListNode root;
    Random random = new Random();
    public LeetCode382(ListNode head) {
        root = head;
    }

    public int getRandom() {
        int returns = 0, index = 0;
        ListNode x = root;
        while (x != null) {
            ++index;
            if (random.nextInt(index) == 0) {
                returns = x.val;
            }
            x = x.next;
        }
        return returns;
    }
}
