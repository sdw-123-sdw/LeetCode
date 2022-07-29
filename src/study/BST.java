package study;

/**
 * @ClassName BST
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/11 21:35
 * @Version 1.0
 */
public class BST {
    class Node{
        public int value;
        public Node left;
        public Node right;
    }
    public static int preValue = Integer.MIN_VALUE;
    public static boolean checkBST(Node head) {
        if(head == null) {
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        if(!isLeftBst) {
            return false;
        }
        if(head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }

    // 套路写法
    public static class ReturnData {
        public boolean isBst;
        public int max;
        public int min;

        public ReturnData(boolean isBst, int max, int min) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
        }
    }

    public static ReturnData process(Node node) {
        if(node == null) {
            // 自己写的错误思想代码已经注释
//            return new ReturnData(true, 0, 0);
            return null;
        }
        ReturnData leftData = process(node);
        ReturnData rightData = process(node);

        int max = node.value;
        int min = node.value;

        // 求出当前树的最大和最小
        if(leftData != null) {
            min = Math.min(leftData.min, min);
            max = Math.max(max, leftData.max);
        }
        if(rightData != null) {
            max = Math.max(max, rightData.max);
            min = Math.min(rightData.min, min);
        }

        boolean isBst = true;
        if((leftData != null && (!leftData.isBst || node.value <= leftData.max))
            ||
            (rightData != null && (!rightData.isBst || node.value >= rightData.min))) {
            isBst = false;
        }

        return new ReturnData(isBst, max, min);
        // 自己写的错误思想代码已经注释
//        boolean isBst = leftData.isBst && rightData.isBst
//        boolean isBst = leftData.isBst && rightData.isBst && leftData.max < node.value && rightData.min > node.value;
//        return new ReturnData(isBst, leftData.min, rightData.max);
    }

    public static String tast2(Node node) {
        ReturnData process = process(node);
        if(process.isBst) {
            return "是搜索二叉树";
        } else {
            return "不是搜索二叉树";
        }
    }
}
