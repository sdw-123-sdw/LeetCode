package leetcode.jianzhier;

/**
 * @ClassName LeetCodejianzhier029
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/18 14:53
 * @Version 1.0
 */
public class LeetCode_jianzhier_029 {
    public Nodes insert(Nodes head, int insertVal) {
        if (head == null) {
            Nodes no = new Nodes(insertVal);
            Nodes de = no;
            no.next = de;
            return no;
        }
        Nodes nodes = head;
        if (nodes.next == head) {
            index(nodes, insertVal);
            return head;
        }
        do {
            Nodes next = nodes.next;
            if (nodes.val > next.val) {
                if ((nodes.val > insertVal && next.val > insertVal) || (nodes.val < insertVal && next.val < insertVal)) {
                    index(nodes, insertVal);
                    return head;
                }
            }
            if ((nodes.val < insertVal && next.val >= insertVal) || (nodes.next == head)) {
                index(nodes, insertVal);
                break;
            }
            nodes = next;
        } while (nodes != head);
        return head;
    }

    private void index(Nodes nodes, int i) {
        Nodes swap = new Nodes(i, nodes.next);
        nodes.next = swap;
    }
}

class Nodes {
    public int val;
    public Nodes next;

    public Nodes() {}

    public Nodes(int _val) {
        val = _val;
    }

    public Nodes(int _val, Nodes _next) {
        val = _val;
        next = _next;
    }
}
