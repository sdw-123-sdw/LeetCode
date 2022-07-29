package study;

/**
 * @ClassName Balanced
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/12 9:26
 * @Version 1.0
 */
public class Balanced {
    class Node{
        public int value;
        public Node left;
        public Node right;
    }

    public static class ReturnType{
        // 返回值中要包含是否是平衡二叉树，还有其深度是多少
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int height) {
            this.height = height;
            this.isBalanced = isB;
        }
    }

    public static ReturnType process(Node node) {
        if(node == null) {
            return new ReturnType(true, 0);
        }

        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);

        int height = Math.max(leftData.height, rightData.height) + 1;   // 高度是左右子树最大高度加上头节点的高度1

        // 判断我是否是平衡二叉树
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;  // 左树是平衡二叉树，右树是平衡儿茶素，并且左右子树高度差小于2

        return new ReturnType(isBalanced, height);
    }

    // 主函数
    public static boolean isBalanced(Node node) {
        return process(node).isBalanced;
    }
}
