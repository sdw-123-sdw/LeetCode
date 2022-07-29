package leetcode.jianzhier;

/**
 * @ClassName LeetCode_jianzhier_063
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/18 10:07
 * @Version 1.0
 */
public class LeetCode_jianzhier_063 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxPrice = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            maxPrice = Math.max(maxPrice, prices[i] - minPrice);
        }
        return maxPrice;
    }
}
