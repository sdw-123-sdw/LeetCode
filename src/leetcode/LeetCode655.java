package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode655
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/23 9:38
 * @Version 1.0
 */
public class LeetCode655 {
    int h;
    String[][] s;
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root) - 1;
        h = height;
        int m = height + 1;
        int n = (int) (Math.pow(2, height + 1) - 1);
        String[][] sFlag = new String[m][n];
        s = sFlag;
        for (String[] strings : sFlag) {
            Arrays.fill(strings, "");
        }
        swap(0, n, root);
        List<List<String>> string = new ArrayList<>();
        for (String[] strings : sFlag) {
            string.add(Arrays.asList(strings));
        }
        return string;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private void swap(int nowRow, int fartherColumn, TreeNode root) {
        int column;
        if (nowRow == 0) {
            column = (fartherColumn - 1) >> 1;
            s[0][column] = root.val + "";
        } else {
            column = fartherColumn;
        }
        ++nowRow;
        int pow = (int) Math.pow(2, h - nowRow);
        if (root.left != null) {
            s[nowRow][column - pow] = root.left.val + "";
            swap(nowRow, column - pow, root.left);
        }
        if (root.right != null) {
            s[nowRow][column + pow] = root.right.val + "";
            swap(nowRow, column + pow, root.right);
        }
    }
}
