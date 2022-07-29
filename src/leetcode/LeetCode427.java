package leetcode;

/**
 * @ClassName LeetCode427
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/29 9:38
 * @Version 1.0
 */
public class LeetCode427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };
    public Node construct(int[][] grid) {
        return swap(grid, 0, 0, grid.length, grid.length);
    }

    // 前缀和
    public Node construct2(int[][] grid) {
        int l = grid.length;
        int[][] pro = new int[l + 1][l + 1];
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                pro[i][j] = pro[i - 1][j] + pro[i][j - 1] - pro[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return swap2(grid, pro, 0, 0, l, l);
    }

    private Node swap(int[][] grid, int x1, int y1, int x2, int y2) {
        boolean andOrNo = true;
        int i1 = grid[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (grid[i][j] != i1) {
                    andOrNo = false;
                    break;
                }
            }
            if (!andOrNo) break;;
        }
        if (andOrNo) {
            return new Node(i1 == 1, true);
        }
        Node node =  new Node(true, false,
                swap(grid, x1, y1, (x1 + x2) >> 1, (y1 + y2) >> 1),
                swap(grid, x1, (y1 + y2) >> 1, (x1 + x2) >> 1, y2),
                swap(grid, (x1 + x2) >> 1, y1, x2, (y1 + y2) >> 1),
                swap(grid, (x1 + x2) >> 1, (y1 + y2) >> 1, x2, y2));
        return node;
    }

    // 前缀和
    private Node swap2(int[][] grid, int[][] pro, int x0, int y0, int x1, int y1) {
        int i = pro[x1][y1] - pro[x0][y1] - pro[x1][y0] + pro[x0][y0];
        if (i == 0) return new Node(false, true);
        if (i == (x1 - x0) * (y1 - y0)) return new Node(true, true);
        Node node = new Node(true, false,
                swap2(grid, pro, x0, y0, (x0 + x1) >> 1, (y0 + y1) >> 1),
                swap2(grid, pro, x0, (y0 + y1) >> 1, (x0 + x1) >> 1, y1),
                swap2(grid, pro, (x0 + x1) >> 1, y0, x1, (y0 + y1) >> 1),
                swap2(grid, pro, (x0 + x1) >> 1, (y0 + y1) >> 1, x1, y1));
        return node;
    }
}
