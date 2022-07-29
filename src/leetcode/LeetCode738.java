package leetcode;

/**
 * @ClassName LeetCode738
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/7 12:19
 * @Version 1.0
 */
public class LeetCode738 {
    /**
     * 可见最终结果必然是若干个形如 11……11 的数字相加所得。
     *
     * 本题中，最大的n为10^9，所以，可以从111111111开始依次累加，如果继续累加将导致结果超过n，则去掉一个1继续循环。总累加次数不超过9次。
     */
    public int monotoneIncreasingDigits(int n) {
        int i = 111111111;
        int sum = 0;
        for (int j = 0; j < 9 && i > 0; j++) {
            while (sum + i > n) {
                i /= 10;
            }
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode738 leetCode738 = new LeetCode738();
        System.out.println(leetCode738.monotoneIncreasingDigits(10));
    }
}
