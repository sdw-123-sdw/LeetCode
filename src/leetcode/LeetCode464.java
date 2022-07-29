package leetcode;


/**
 * @ClassName LeetCode464
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/24 21:56
 * @Version 1.0
 */
public class LeetCode464 {
    // 来存储出现过得可能性
    // visited[x] = 0:未出现过这种可能性
    // visited[x] = 1;出现过,但是当前选择人一定赢,返回true
    // visited[x] = 2;出现过,但是当前选择人一定输,返回false
    int[] visited = new int[1 << 21];
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 如果最大可取到的值大于和，直接赢
        if (maxChoosableInteger >= desiredTotal) return true;
        // 如果所有数的和加起来没超过需求和，直接输。利用前n项和公式
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        // 计算先手输赢
        // state：当前已选择的和未选择的，利用二进制进行统计
        // sum: 当前已经选择的数的和
        return dfs(0, 0, maxChoosableInteger, desiredTotal);
    }

    /**
     * 利用记忆化搜索进行搜索
     * @param state 表示已选择的和未选择的
     * @param sum 当前已选择的数的和
     * @param maxChoosableInteger 最大选择数
     * @param desiredTotal 目标和数
     * @return
     */
    private boolean dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
        // 当前结果之前已经被之前选择过，直接返回
        if (visited[state] == 1) return true;
        if (visited[state] == 2) return false;
        // 遍历所有能选择的数
        for (int i = 1; i <= maxChoosableInteger; i++) {
            // 如果当前数已经被选择过了，直接跳过
            // 这里还可以判断是否大于0
            if (((1 << i) & state) == (1 << i)) continue;
            // 如果加上这个数能直接赢，那么直接返回true
            if (sum + i >= desiredTotal) {
                visited[state] = 1;
                return true;
            }
            // 如果选择了这个，能稳赢，那么直接返回true
            // 我先手已经完成，下面这个就是对手的下一次的选择，如果返回false，那么代表我赢了
            if (!dfs((1 << i) | state, sum + i, maxChoosableInteger, desiredTotal)) {
                // 我赢就将这种可能置位1，并返回true
                visited[state] = 1;
                return true;
            }
        }
        // 当前结果不能赢，置位2，返回false
        visited[state] = 2;
        return false;
    }
}
