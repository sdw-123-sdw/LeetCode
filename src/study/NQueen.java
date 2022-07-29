package study;

/**
 * @ClassName NQueen
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/27 10:53
 * @Version 1.0
 */
public class NQueen {
    public int num1(int n) {
        if (n < 1) {
            return 0;
        }
        // record[0]第0行的放在第几列？……
        int[] record = new int[n]; // record[i] -> i行的皇后，放在了第几列
        return process1(0, record, n);
    }

    /*
    目前来到了第i行
    record[0..i-1]表示之前的行,放了皇后位置
    n代表整体一共有多少行
    返回值是,摆完所有的皇后,合理的摆法有多少种
     */
    public int process1(int i, int[] record, int n) {
        if (i == n) { // 超出去了,也就意味着最后真正的最后一行已经找到了正确的摆法,也就是这一次全部摆完了,算一种方法,所以应该返回1
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            /*
            当前i行的皇后,放在j列,会不会和之前(0..j-1)的皇后,共行共列或者共斜线
            如果是,认为无效
            如果不是,认为有效
             */
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    // record[0...i-1]你需要看，record[i...]不需要看,因为后面还没有放
    // 返回i行皇后,放在了j列,是否有效
    public boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) { // 行之差是否等于列之差,等于就是在一条直线上,因为是45度,等腰直角三角形
                return false;
            }
        }
        return true;
    }

    /*---------------------------------------常数级别优化--------------------------------------*/
    // 请不要超过32皇后问题,如果坚持要解决,那么把n换成long类型
    public int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    /*
    colLim：列的限制，1的位置上不能放皇后，0的位置可以
    leftDiaLim：左斜线的限制，1的位置不能放皇后，0的位置可以
    rightDiaLim：右斜线的限制，1的位置不能放皇后，0的位置可以
     */
    public int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) { // base case
            return 1;
        }
        int pos = 0;
        int mostRighOne = 0;
        /*
        和limit与是想把他左侧给他截了，也就是控制位数
         */
        pos = limit & (~(colLim | leftDiaLim | rightDiaLim)); // colLim | leftDiaLim | rightDiaLim:总限制
        int res = 0;
        while (pos != 0) {
            // 提取出pos中最右侧的1，mostRighOne放皇后的位置
            mostRighOne = pos & (~pos + 1);
            pos = pos - mostRighOne;
            /*
            colLim | mostRighOne：列限制为上一列的列限制和本列放了皇后的位置做或运算
             */
            res += process2(limit, colLim | mostRighOne, (leftDiaLim | mostRighOne) << 1, (rightDiaLim | mostRighOne) >>> 1);
        }
        return res;
    }
}
