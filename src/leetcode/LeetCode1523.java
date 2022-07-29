package leetcode;

/**
 * @ClassName LeetCode1523
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/25 22:51
 * @Version 1.0
 */
public class LeetCode1523 {
    /*
    我们可以使用前缀和思想来解决这个问题，定义 pre(x) 为区间 [0,x] 中奇数的个数，很显然：
    pre(x)=(x+1)/2
    故答案为 pre(high) - pre(low - 1)
     */
    public int countOdds(int low, int high) {
       return ((high + 1) >> 1) - (low >> 1);
    }
}
