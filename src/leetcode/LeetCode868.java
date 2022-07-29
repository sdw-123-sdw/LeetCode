package leetcode;

/**
 * @ClassName LeetCode868
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/24 9:30
 * @Version 1.0
 */
public class LeetCode868 {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();

        int j = -1;
        int min = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                if (j != -1) {
                    min = Math.max(min, i - j);
                }
                j = i;
            }
        }
        return min;
    }

    // 二进制计算
    public int binaryGap2(int n) {
        int min = 0;
        int j = -1;
        for (int i = 0; n != 0; i++) {
            if ((n & 1) == 1) {
                if (j != -1) {
                    min = Math.max(min, i - j);
                }
                j = i;
            }
            n = n >> 1;
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode868 leetCode868 = new LeetCode868();
        System.out.println(leetCode868.binaryGap(22));
    }
}
