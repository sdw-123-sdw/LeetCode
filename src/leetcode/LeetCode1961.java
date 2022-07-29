package leetcode;

/**
 * @ClassName LeetCode1961
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/12 10:43
 * @Version 1.0
 */
public class LeetCode1961 {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder string = new StringBuilder();
        for (String word : words) {
            string.append(word);
            if (s.equals(string.toString())) return true;
        }
        return false;
    }
    public boolean isPrefixString1(String s, String[] words) {
        int arryi = 0;
        int arryik = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arryik >= words[arryi].length()) {
                arryik = 0;
                arryi++;
            }
            if (arryi >= words.length) {
                return false;
            }
            if (words[arryi].charAt(arryik) != s.charAt(i)) {
                return false;
            }
            arryik++;
        }
        return arryik == words[arryi].length();
    }
}