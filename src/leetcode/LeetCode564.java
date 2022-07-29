package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode564
 * @Description TODO
 * @Author: 索德文
 * @date 2022/3/2 9:42
 * @Version 1.0
 */
public class LeetCode564 {
    public String nearestPalindromic(String n) {
        System.out.println(n);
        int length = n.length();
        int i = Integer.parseInt(n);
        if (n == "10") return "9";
        if (n == "11") return "9";
        if (length == 1) return String.valueOf(i - 1);

        char[] chars = n.toCharArray();
        for (int i1 = 0, j = length - 1; j > i1; i1++, j--) {
            chars[j] = chars[i1];
        }
        int i1 = Integer.parseInt(String.valueOf(chars));
        int count = 0;
        if (length % 2 == 0) {
            count = 1;
            for (int i2 = 0; i2 < length / 2; i2++) {
                count *= 10;
            }
        }else {
            count = 11;
            for (int i2 = 1; i2 < length / 2; i2++) {
                count *= 10;
            }
        }
        int i2 = i1 + count;
        int i3 = i1 - count;
        if (i == i1) {
            return Math.abs(i - i2) < Math.abs(i - i3) ? String.valueOf(i2) : String.valueOf(i3);
        }
        if (i < i1) {
            return Math.abs(i - i1) < Math.abs(i - i3) ? String.valueOf(i1) : String.valueOf(i3);
        } else {
            return Math.abs(i - i1) < Math.abs(i - i2) ? String.valueOf(i1) : String.valueOf(i2);
        }
    }

    public static void main(String[] args) {
        LeetCode564 leetCode564 = new LeetCode564();
        System.out.println(leetCode564.nearestPalindromic("10"));
    }

    // 上面的是错误的，下面为正确，上面没有考虑全是9的情况，没有考虑long。
    public String nearestPalindromic1(String s) {
        int n = s.length();
        long cur = Long.parseLong(s);
        Set<Long> set = new HashSet<>();
        set.add((long) Math.pow(10, n - 1) - 1);
        set.add((long) Math.pow(10, n) + 1);
        long t = Long.parseLong(s.substring(0, (n + 1) / 2));
        for (long i = t - 1; i <= t + 1; i++) {
            long temp = -1;
            if (n % 2 == 0) temp = getNum(i, true);
            else temp = getNum(i, false);
            if (temp != cur) set.add(temp);
        }
        long ans = -1;
        for (long i : set) {
            if (ans == -1) ans = i;
            else if (Math.abs(i - cur) < Math.abs(ans - cur)) ans = i;
            else if (Math.abs(i - cur) == Math.abs(ans - cur) && i < ans) ans = i;
        }
        return String.valueOf(ans);
    }
    long getNum(long k, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        int idx = isEven ? sb.length() - 1 : sb.length() - 2;
        while (idx >= 0) sb.append(sb.charAt(idx--));
        return Long.parseLong(sb.toString());
    }
}
