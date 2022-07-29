package leetcode;

/**
 * @ClassName LeetCode468
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/29 10:05
 * @Version 1.0
 */
public class LeetCode468 {
    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf(".") > 0) { // IPv4
            String[] split = queryIP.split("\\.", 4);
            if (split.length != 4) return "Neither";
            for (String s : split) {
                if (s.isEmpty() || (s.length() != 1 && s.charAt(0) == '0')) return "Neither";
                if (s.length() > 3) return "Neither";
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(s.charAt(i))) {
                        return "Neither";
                    }
                }
                int i = Integer.parseInt(s);
                if (i < 0 || i > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else { // IPv6
            String[] split = queryIP.split(":", 8);
            if (split.length != 8) return "Neither";
            for (String s : split) {
                if (s.length() > 4 || s.length() < 1) return "Neither";
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (Character.isDigit(c)) {
                        continue;
                    } else if ((c >= 65 && c <= 70) || (c >= 97 && c <= 102)) {
                        continue;
                    } else {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }

    public static void main(String[] args) {
        LeetCode468 leetCode468 = new LeetCode468();
        System.out.println(leetCode468.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:"));
    }
}
