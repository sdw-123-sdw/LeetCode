package leetcode;

/**
 * @ClassName LeetCode668_
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/18 9:58
 * @Version 1.0
 */
public class LeetCode668_ {
    /*
    二分 + 计数判定
    由于 n 和 m 的数据范围都是 3 ×10^4，总数本身就超过了 10^7，我们考虑线性复杂度往下的对数复杂度。
    题目要求我们求一维展开有序序列中的第 k 小的数，问题本身具有「二段性」：
        答案右边的每个数均 满足「其在一维展开有序序列中左边数的个数大于等于 k 个」
        答案左边的每个数均 不满足「其在一维展开有序序列中左边数的个数大于等于 k 个」
    我们考虑如何进行「二分答案」: 假设当前我们二分到的值是 mid，对于乘法表中的每行和每列均是单调递增，
    我们可以通过累加统计 每行/每列 中比 mid 小的数，记作 a，累加统计 每行/每列 中等于 mid 的数，记作 b，那么 cnt = a + b
    即是整个乘法表中小于等于 mid 的数的个数，再通过 cnt 和 k 的大小关系来指导左右指针的变化。
    具体的，假设我们通过枚举行来统计 a 和 b，当前枚举到的行号为 i（行号从 1 开始），该行的最大数为 i × m：
        若 i × m < mid，整行都是小于 mid 的数，直接在 a 基础上累加 m；
        若 i × m >= mid，根据 mid 是否存在于该行进行分情况讨论：
            mid 能够被 i 整除，说明 mid 存在于该行，那么比 mid 小的数的个数为 mid / i - 1，将其累加到 a，同时对 b 进行加一；
            mid 不能够被 i 整除，说明 mid 不存在于该行，那么比 mid 小的数的个数为 mid / i，将其累加到 a。
     */
    int n, m, k;
    public int findKthNumber(int _m, int _n, int _k) {
        n = Math.min(_m, _n); m = Math.max(_m, _n); k = _k;
        int l = 1, r = m * n;
        while (l < r) {
            int mid = l + r >> 1, cnt = getCnt(mid);
            if (cnt >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    int getCnt(int mid) {
        int a = 0, b = 0;
        for (int i = 1; i <= n; i++) {
            if (i * m < mid) {
                a += m;
            } else {
                if (mid % i == 0 && ++b >= 0) a += mid / i - 1;
                else a += mid / i;
            }
        }
        return a + b;
    }
}
