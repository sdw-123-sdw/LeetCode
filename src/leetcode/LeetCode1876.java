package leetcode;

import java.util.List;

/**
 * @ClassName LeetCode1876
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/17 10:45
 * @Version 1.0
 */
public class LeetCode1876 {
    public int countGoodSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n - 2; ++i){
            if (s.charAt(i) != s.charAt(i+1) && s.charAt(i) != s.charAt(i+2) && s.charAt(i+1) != s.charAt(i+2)){
                ++res;
            }
        }
        return res;
    }
    public int countGoodSubstrings2(String s) {
        if(s.length() < 3){
            return 0;
        }

        int count = 0;
        char[] chs = s.toCharArray();
        for(int i=0; i < chs.length-2; i++){
            int a = (int)chs[i];
            int b = (int)chs[i+1];
            int c = (int)chs[i+2];

            int d = a ^ b ^ c;
            if(d != a && d != b && d != c){
                count++;
            } else {
                if(b == c){
                    i++;
                }
            }
        }

        return count;
    }
}
