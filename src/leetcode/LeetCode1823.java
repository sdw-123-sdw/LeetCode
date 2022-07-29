package leetcode;

import java.util.LinkedList;

/**
 * @ClassName LeetCode1823
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/4 9:51
 * @Version 1.0
 */
public class LeetCode1823 {
    public int findTheWinner(int n, int k) {
        if (n == 1) return 1;
        LinkedList<Integer> list = new LinkedList();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() != 1) {
            i = (i + k - 1) % list.size();
            list.remove(i);
            if (i == list.size()) i = 0;
        }
        return  list.get(0) + 1;
    }

    // 逆向思维，最后肯定是在索引为0的位置，那我们从后往回推
    // 推到最后这个索引为0的数在原数组哪个位置
    // https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/solution/by-fuxuemingzhu-laof/
    public int findTheWinner2(int n, int k) {
        int i = 0;  // 初始在0位置
        // 因为1个数的时候不需要讨论了,最后结果就是只剩1个数字,所以从还剩2个数字开始
        // 最后要添加到有n个数
        for (int j = 2; j <= n; j++) {
            i = (i + k) % j;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        LeetCode1823 leetCode1823 = new LeetCode1823();
        System.out.println(leetCode1823.findTheWinner(5, 2));
    }
}
