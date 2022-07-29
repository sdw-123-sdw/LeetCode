package leetcode.jianzhier;

/**
 * @ClassName LeetCode_jianzhier_002
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/25 11:28
 * @Version 1.0
 */
public class LeetCode_jianzhier_002 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1,j = b.length() - 1;
        int pro = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || pro != 0) {
            int ca = i < 0 ? 0 : a.charAt(i--) - '0';
            int cb = j < 0 ? 0 : b.charAt(j--) - '0';
            sb.append((ca ^ cb) ^ pro);
            if (ca == 0 || cb == 0) pro = (ca ^ cb) & pro;
            else pro = 1;//ca和cb都是1，直接进位
        }
        return sb.reverse().toString();
    }
}
