package leetcode;

/**
 * @ClassName LeetCode796
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/7 9:59
 * @Version 1.0
 */
public class LeetCode796 {
    public boolean rotateString(String s, String goal) {
        // contains代表前置字符串是否包含目标字符序列（goal）
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
