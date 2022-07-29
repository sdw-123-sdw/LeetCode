package study;

/**
 * @ClassName FullTree
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/12 11:02
 * @Version 1.0
 */
public class FullTree {
    class Node{
        public int value;
        public Node left;
        public Node right;
    }
    public static class Info{
        public int height;
        public int nodeNum;
        public Info(int height, int nodeNum) {
            this.height = height;
            this.nodeNum = nodeNum;
        }
    }

    public static Info full(Node node) {
        if(node == null) {
            return new Info(0, 0);
        }

        Info leftInfo = full(node.left);
        Info rightInfo = full(node.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodeNum = leftInfo.nodeNum + rightInfo.nodeNum + 1;

        return new Info(height, nodeNum);
    }

    public static boolean isF(Node node) {
        if(node == null) {
            return true;
        }
        Info full = full(node);

        return full.nodeNum == ((1 << full.height) - 1);
    }
}
