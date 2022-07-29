package leetcode;

/**
 * @ClassName LeetCode1974
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/19 10:26
 * @Version 1.0
 */
public class LeetCode1974 {
    public int minTimeToType(String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                count += Math.min(chars[i] - 'a', 26 - Math.abs(chars[i] - 'a')) + 1;
            } else {
                int abs = Math.abs(chars[i] - chars[i - 1]);
                count += Math.min(abs, 26 - abs) + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1974 leetCode1974 = new LeetCode1974();
        System.out.println(leetCode1974.minTimeToType("bza"));
    }
}
