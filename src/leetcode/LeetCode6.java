package leetcode;

/**
 * @ClassName LeetCode6
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/1 10:58
 * @Version 1.0
 */
public class LeetCode6 {
    public String convert(String s, int r) {
        int n = s.length();
        if (n == 1 || r == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            if (i == 0 || i == r - 1) {
                int pos = i, offset = 2 * (r - 1);
                while (pos < n) {
                    sb.append(s.charAt(pos));
                    pos += offset;
                }
            } else {
                int pos1 = i, pos2 = 2 * r - i - 2;
                int offset = 2 * (r - 1);
                while (pos1 < n || pos2 < n) {
                    if (pos1 < n) {
                        sb.append(s.charAt(pos1));
                        pos1 += offset;
                    }
                    if (pos2 < n) {
                        sb.append(s.charAt(pos2));
                        pos2 += offset;
                    }
                }
            }
        }
        return sb.toString();
    }
}
