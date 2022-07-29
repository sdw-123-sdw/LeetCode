package leetcode;

/**
 * @ClassName leetcode.LeetCode520
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/13 20:09
 * @Version 1.0
 */
public class LeetCode520 {
    public boolean detectCapitalUse(String word) {
        int big = 0;
        int small = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a') {
                small++;
            } else {
                big++;
            }
        }
        if(small == word.length() || big == word.length()) {
            return true;
        } else if(word.charAt(0) < 'a' && small == (word.length() - 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode520 leetCode520 = new LeetCode520();
        System.out.println(leetCode520.detectCapitalUse("Flag"));
    }
}
