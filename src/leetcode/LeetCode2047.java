package leetcode;

/**
 * @ClassName LeetCode2047
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/27 11:16
 * @Version 1.0
 */
public class LeetCode2047 {
    public int countValidWords(String sentence) {
        String[] ss = sentence.split(" ");
        int ans = 0;
        for (String s : ss) if (check(s)) ans++;
        return ans;
    }
    private boolean check(String s) {
        int n = s.length();
        if (n == 0) return false;
        for (int i = 0, c1 = 0, c2 = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) return false; // 判断是否为数字
            if (c == ' ') return false;
            if (c == '-' && ++c1 >= 0) {
                if (c1 > 1 || (i == 0 || i == n - 1)) return false;
                if (!Character.isLetter(s.charAt(i - 1)) || !Character.isLetter(s.charAt(i + 1))) return false; // 判断是否为字母
            }
            if ((c == '!' || c == '.' || c == ',') && ++c2 >= 0) {
                if (c2 > 1 || (i != n - 1)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode2047 leetCode2047 = new LeetCode2047();
        System.out.println(leetCode2047.countValidWords("cat and      dog"));
    }
}
