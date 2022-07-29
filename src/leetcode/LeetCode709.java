package leetcode;

/**
 * @ClassName LeetCode709
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/12 1:18
 * @Version 1.0
 */
public class LeetCode709 {
    public String toLowerCase(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                stringBuilder.append((char) (s.charAt(i) | 32));
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode709 leetCode709 = new LeetCode709();
        System.out.println(leetCode709.toLowerCase("SFhasdkjfhka"));
    }
}
