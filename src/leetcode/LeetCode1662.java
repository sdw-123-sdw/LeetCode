package leetcode;

/**
 * @ClassName LeetCode1662
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/8 17:17
 * @Version 1.0
 */
public class LeetCode1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s = new StringBuilder();
        for (String s1 : word1) {
            s.append(s1);
        }
        StringBuilder s2 = new StringBuilder();
        for (String s1 : word2) {
            s2.append(s1);
        }
        return s.toString().equals(s2.toString());
    }
}
