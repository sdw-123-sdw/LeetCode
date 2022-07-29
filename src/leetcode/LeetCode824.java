package leetcode;

/**
 * @ClassName LeetCode824
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/21 8:55
 * @Version 1.0
 */
public class LeetCode824 {
    public String toGoatLatin(String sentence) {
        StringBuilder s = new StringBuilder();
        String[] s1 = sentence.split(" ");
        for (int i = 0; i < s1.length; i++) {
            String substring1 = s1[i].substring(0, 1);
            String substring = substring1.toLowerCase();
            if (!substring .equals("a") &&
                !substring .equals("e") &&
                !substring .equals("i") &&
                !substring .equals("o") &&
                !substring .equals("u")) {
                s.append(s1[i].substring(1)).append(substring1);
            } else {
                s.append(s1[i]);
            }
            s.append("ma");
            for (int i1 = 0; i1 <= i; i1++) {
                s.append("a");
            }
            s.append(" ");
        }
        s.deleteCharAt(s.length() - 1);
        return s.toString();
    }

    public static void main(String[] args) {
        LeetCode824 leetCode824 = new LeetCode824();
        System.out.println(leetCode824.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
