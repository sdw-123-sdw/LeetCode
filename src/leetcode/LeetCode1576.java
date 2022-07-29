package leetcode;

import java.util.Random;

/**
 * @ClassName LeetCode1576
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/5 10:22
 * @Version 1.0
 */
public class LeetCode1576 {
    char[] choice = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    Random random = new Random();
    public String modifyString(String s) {
        if (s.length() == 1 && s == "?") return "a";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                while (true) {
                    int i1 = random.nextInt(25);
                    if ((i == 0 && choice[i1] != chars[i + 1]) ||
                            (i == chars.length - 1 && choice[i1] != chars[i - 1]) ||
                            (choice[i1] != chars[i - 1] && choice[i1] != chars[i + 1])) {
                        chars[i] = choice[i1];
                        break;
                    }
                }
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        LeetCode1576 leetCode1576 = new LeetCode1576();
        System.out.println(leetCode1576.modifyString("?"));
    }
}
