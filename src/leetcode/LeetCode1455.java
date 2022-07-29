package leetcode;

/**
 * @ClassName LeetCode1455
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/28 10:51
 * @Version 1.0
 */
public class LeetCode1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        int l = searchWord.length();
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() < l) {
                continue;
            }
            if (searchWord.equals(s[i].substring(0, l))) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "01234567";
        System.out.println(s.substring(0, 3));
    }
}
