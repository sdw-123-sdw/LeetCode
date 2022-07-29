package study;

import java.util.LinkedList;

/**
 * @ClassName CBT
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/11 22:00
 * @Version 1.0
 */
class Node{
    public int value;
    public Node left;
    public Node right;
    public Node(int value) {
        this.value = value;
    }
}
public class CBT {
    public static boolean isCBT(Node head) {
        if(head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean left = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if((left && (l != null && r != null))  // 已经遇到过左右孩子不双全，并且当前节点不是叶节点
                ||
                (l == null && r != null)   // 左孩子为空而右孩子不为空
            ) {
                return false;
            }

            if(l != null) {
                queue.add(l);
            }
            if(r != null) {
                queue.add(r);
            }
            if(l == null || r == null) {
                left = true;
            }
        }
        return true;
    }
}

