package study;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName CreatTwoNodegz
 * @Description 生成a1和a2的最低公共祖先
 * @Author: 索德文
 * @date 2021/11/20 20:20
 * @Version 1.0
 */
public class CreatTwoNodegz {
    /*
    方法一：
     */
    // 默认条件，a1和a2一定属于head为头的树
    public static Node lca(Node head, Node a1, Node a2) {
        // 每一个节点的父节点
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, head);
        process(head, map);
        HashSet<Node> set = new HashSet<>();
        // 将a1以及a1的所有父节点挨个全部放入set集合中，利用set不能放重复的特性，再讲a2及a2的父节点挨个向里面放，如果为false那么就是这个节点
        set.add(a1);
        Node flag = a1;
        while (a1 != map.get(a1)) {
            flag = map.get(flag);
            set.add(flag);
        }
        set.add(head);

        while (set.add(a2)) {
            a2 = map.get(a2);
        }
        return a2;
    }

    public static void process(Node head, HashMap<Node, Node> map) {
        if(head == null) {
            return;
        }
        map.put(head.left, head);
        map.put(head.right, head);
        process(head.left, map);
        process(head.right, map);
    }

    /*
    方法二:
     */
    public static Node lowestAncestor(Node head, Node a1, Node a2) {
        if(head == null || head == a2 || head == a1) {
            return head;
        }
        Node left = lowestAncestor(head.left, a1, a2);
        Node right = lowestAncestor(head.right, a1, a2);
        if(left != null && right != null) {
            return head;
        }
        // 左右两棵树，并不都为返回值
        return left != null ? left : right;
    }
}
