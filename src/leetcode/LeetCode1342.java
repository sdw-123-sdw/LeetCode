package leetcode;

/**
 * @ClassName LeetCode1342
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/31 2:19
 * @Version 1.0
 */
public class LeetCode1342 {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 ==0) {
                num = num >> 1;
            } else {
                --num;
            }
            ++count;
        }
        return count;
    }
}
