package leetcode;

/**
 * @ClassName leetcode.LeetCode237
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/2 9:18
 * @Version 1.0
 */
public class LeetCode237 {
    public void deleteNode(ListNodes node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    public void deleteNodes(ListNodes node) {
        node.val = node.next.val;
        node.next = node.next.next ;
    }
}

class ListNodes {
    int val;
    ListNodes next;
    ListNodes(int x) { val = x; }
}