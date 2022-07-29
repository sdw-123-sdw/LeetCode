package leetcode;

/**
 * @ClassName LeetCode1318
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/16 20:27
 * @Version 1.0
 */
public class LeetCode1318 {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (c != 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    ++count;
                }
            } else {
                if ((a & 1) == 1) {
                    ++count;
                }
                if ((b & 1) == 1) {
                    ++count;
                }
            }
            c = c >> 1;
            a = a >> 1;
            b = b >> 1;
        }
        while (a != 0) {
            if ((a & 1) == 1) {
                ++count;
            }
            a = a >> 1;
        }
        while (b != 0) {
            if ((b & 1) == 1) {
                ++count;
            }
            b = b >> 1;
        }
        return count;
    }
}
