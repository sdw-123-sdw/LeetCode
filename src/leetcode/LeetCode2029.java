package leetcode;

/**
 * @ClassName LeetCode2029
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/20 16:31
 * @Version 1.0
 */
public class LeetCode2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] cnts = new int[3];
        for (int i : stones) cnts[i % 3]++;
        return cnts[0] % 2 == 0 ? !(cnts[1] == 0 || cnts[2] == 0) : !(Math.abs(cnts[1] - cnts[2]) <= 2);
    }
}
