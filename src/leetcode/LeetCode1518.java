package leetcode;

/**
 * @ClassName LeetCode1518
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/17 8:47
 * @Version 1.0
 */
public class LeetCode1518 {
    /*
    对于这道题，分析可得，换酒瓶其实就是加一瓶减m瓶，所以其实就是减了m-1瓶，所以要算一共能喝多少瓶其实就是这numBottles能换多少瓶，numBottles/m+1
    对于官方题解：换酒瓶子的条件为numBottles - n(numExchange - 1) >= numBottles,所以我们想知道第一个打破下面条件的n，
                即我们要找到最小的n使得：numBottles - n(numExchange - 1) < numBottles,转换一下n > (b - e) / (e - 1)
                那么，最小的值就是右面那一坨+1即为最小
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;
    }

    /*
    对于宫水大佬的方法来说，相对好理解，计算出 numBottles / (numExchange - 1)能换多少瓶之后，有一个临界值，那就是若是最后一次换，我手中剩余酒瓶
    正好是numExchange - 1的话是正好不能换的，因为我们换是要numExchange个，此时我要是将这么多换了加上那个瓶子才正好是numExchange，所以不能换，
    但是计算的时候把他算进去了，所以要减一
     */
    public int numWaterBottles2(int numBottles, int numExchange) {
        int count = numBottles / (numExchange - 1);
        return numBottles % (numExchange - 1) == 0 ? count - 1 + numBottles : count + numBottles;
    }
}
