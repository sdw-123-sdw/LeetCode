package leetcode;

/**
 * @ClassName LeetCode521
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/5 15:03
 * @Version 1.0
 */
public class LeetCode521 {
    public int findLUSlength(String a, String b) {
        return b.equals(a) ? -1 : Math.max(a.length(), b.length());
    }
}
