package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode748
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/10 8:28
 * @Version 1.0
 */
public class LeetCode748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] chars = licensePlate.toCharArray();
        int[] ints = new int[26];
        for (char aChar : chars) {
            if (aChar >= 'A' & aChar <= 'z') {
                if (aChar >= 'a' && aChar <= 'z') {
                    ++ints[aChar - 'a'];
                } else {
                    ++ints[aChar - 'A'];
                }
            }
        }
        String maxString = null;
        boolean flag;
        for (String word : words) {
            flag = true;
            int[] ints1 = new int[26];
            for (char c : word.toCharArray()) {
                if (c >= 'A' & c <= 'z') {
                    if (c >= 'a' && c <= 'z') {
                        ++ints1[c - 'a'];
                    } else {
                        ++ints1[c - 'A'];
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if (ints1[i] < ints[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                maxString = maxString == null ? word : maxString.length() <= word.length() ? maxString : word;
        }
        return maxString;
    }

    /*===================================================================================================================*/
    public String shortestCompletingWord2(String licensePlate, String[] words) {
        int[] license = new int[26];
        for(char c : licensePlate.toCharArray()){
            if(c >= 'a' && c <= 'z')
                license[c - 'a']++;
            else if(c >= 'A' && c <= 'Z')
                license[c - 'A']++;
        }
        String res = null;
        for(String word : words){
            if(isContains(license,word))
                if(res == null || word.length() < res.length())
                    res = word;
        }

        return res;
    }

    private boolean isContains(int[] license,String word){
        int[] ans = new int[26];
        for(char c : word.toCharArray()){
            if(c >= 'a' && c <= 'z')
                ans[c - 'a']++;
            else if(c >= 'A' && c <= 'Z')
                ans[c - 'A']++;
        }

        for(int i = 0;i < 26;i++)
            if(ans[i] < license[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(1 << 5);
    }
}
