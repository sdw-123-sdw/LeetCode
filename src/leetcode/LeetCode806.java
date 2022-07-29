package leetcode;

/**
 * @ClassName LeetCode806
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/12 10:20
 * @Version 1.0
 */
public class LeetCode806 {
    public int[] numberOfLines(int[] widths, String s) {
        char[] chars = s.toCharArray();
        int count = 1;
        int flag = 0;
        for (char aChar : chars) {
            flag += widths[aChar - 'a'];
            if (flag > 100) {
                flag = 0;
                ++count;
                flag += widths[aChar - 'a'];
            }
        }
        return new int[]{count, flag};
    }
}
