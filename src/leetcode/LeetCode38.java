package leetcode;

/**
 * @ClassName leetcode.LeetCode38
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/15 16:00
 * @Version 1.0
 */
public class LeetCode38 {
    // 打表
    public static String countAndSay(int n) {
        String[] table = new String[31];
        table[0] = "";
        table[1] = "1";
        table[2] = "11";
        if(n == 1 || n == 2) {
            return table[n];
        }
        for(int i = 3; i <= n; i++) {
            String one  = table[i - 1];
            int count = 1;
            String target = "";
            for(int j = 1; j < one.length(); j++) {
                if(one.charAt(j) != one.charAt(j - 1)) {
                    if(j == (one.length() - 1)) {
                        target = target + count + "" + one.charAt(j - 1) + 1 + "" + one.charAt(j);
                    } else {
                        target = target + count + "" + one.charAt(j - 1) ;
                        count = 1;
                        continue;
                    }
                }
                count++;
            }
            if(one.charAt(one.length() - 1) == one.charAt(one.length() - 2)) {
                target = target + "" + count + "" + one.charAt(one.length() - 2) + "";
            }
            table[i] = target;
        }
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
        int i = 2;
        String s = i + "" + 3;
        System.out.println("s = " + s);
    }
}
