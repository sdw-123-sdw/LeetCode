package leetcode;

/**
 * @ClassName LeetCode307
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/4 22:06
 * @Version 1.0
 */
public class LeetCode307 {
    // 从1开始
    private int[] sum;
    // 从0开始
    private int[] arr;
    // 初始化
    public LeetCode307(int[] nums) {
        int length = nums.length + 1;
        sum = new int[length << 2];  // 用来求和
        arr = nums;
        build(1, length - 1, 1);
    }

    // 用来求该节点的和
    // 该节点的和等于左右节点相加
    // 左节点等于 i * 2,右节点等于 i * 2 + 1
    private void sum(int rt) {
        // 左移一位 = * 2,左移后最后一位一定是0,所以与 1 进行或操作就是 + 1操作,使用位运算是因为计算速度快
        sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
    }

    /**
     * 在原始数组arr[l~r]的范围上去构建
     * @param left 下标左边界
     * @param right 下标右边界
     * @param rt 当前节点,也就是左右边界在sum中的下标
     */
    private void build(int left, int right, int rt) {
        // 判断是否到了根节点，也就是原始数组的位置，1=1的和就是原先下标为0的位置
        if (left == right) {
            sum[rt] = arr[left - 1];
            System.out.println(sum[rt] + "+++++++");
            return;
        }
        // 原数组下标节点二分，左右各原来一半下标
        int mid = (left + right) >> 1;
        // 递归构建整个和
        build(left, mid, rt << 1);
        build(mid + 1, right, rt << 1 | 1);
        // 子构建好之后求本节点的和
        sum(rt);
        System.out.println(sum[rt] + "-------");
    }

    // 更新操作
    public void update(int index, int val) {
        int i = arr[index] - val;
        arr[index] = val;
        int count = 1;
        sum[count] -= i;
        int start = 0;
        int end = arr.length - 1;
        count = count << 1;
        while (count < sum.length && end != start) {
            int mid = (start + end) >> 1;
            if (index > mid) {
                sum[count | 1] -= i;
                count = count | 1;
                start = mid + 1;
            } else {
                sum[count] -= i;
                end = mid;
            }
            count = count << 1;
        }
    }

    // 求和操作
    public int sumRange(int left, int right) {
        return query(left, right, 0, arr.length - 1, 1);
    }

    /**
     *
     * @param L 题目要求左边界
     * @param R 题目要求右边界
     * @param left sum中保存的左边界
     * @param right sum中保存的右边界
     * @param rt 当前节点，左右边界在sum中的下标
     */
    private int query(int L, int R, int left, int right, int rt) {
        if (L <= left && R >= right) {
            return sum[rt];
        }
        int mid = (left + right) >> 1;
        int ans = 0;
        if (L <= mid) {
            ans += query(L, R, left, mid, rt << 1);
        }
        if (R > mid) {
            ans += query(L, R, mid + 1, right, rt << 1 | 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode307 leetCode307 = new LeetCode307(new int[]{7 ,2, 7, 2, 0});
        leetCode307.update(4, 6);
        leetCode307.update(0, 2);
        leetCode307.update(0, 9);
        System.out.println(leetCode307.sumRange(4, 4));
        leetCode307.update(3, 8);
        System.out.println(leetCode307.sumRange(0, 4));
        leetCode307.update(4, 1);
        System.out.println(leetCode307.sumRange(0, 3));
        System.out.println(leetCode307.sumRange(0, 4));
        leetCode307.update(0, 4);
//        System.out.println(leetCode307.sumRange(4, 4));

    }
}
