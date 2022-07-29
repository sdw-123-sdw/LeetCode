package study;

/**
 * @ClassName GetAfterNode
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/20 22:08
 * @Version 1.0
 */
public class GetAfterNode {
    class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if(node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while(parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
