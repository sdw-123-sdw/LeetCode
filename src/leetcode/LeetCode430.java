package leetcode;

import java.util.LinkedList;

/**
 * @ClassName leetcode.LeetCode430
 * @Description TODO
 * @Author: 索德文
 * @date 2021/9/24 17:37
 * @Version 1.0
 */
public class LeetCode430 {
    // 传入的是已经构建好的第一个头结点，深度优先遍历即可
    public Node flatten(Node head) {
        if (head == null) return null;
        LinkedList<Node> stack = new LinkedList<>();
        Node cur = head;
        while (true) {
            if (cur.child != null) {
                // 将 next 节点入栈
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                // 将子链表扁平化
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            // 遍历子链表的下一个节点或是从栈中弹出 next 节点
            if (cur.next != null) {
                cur = cur.next;
            } else if (!stack.isEmpty()) {
                Node next = stack.pop();
                cur.next = next;
                next.prev = cur;
                cur = next;
            } else {
                return head;
            }
        }
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};