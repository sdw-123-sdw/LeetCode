package leetcode;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @ClassName LeetCode383
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/4 8:47
 * @Version 1.0
 */
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ++counts[ransomNote.charAt(i) - 'a'];
        }
        for (int i = 0; i < magazine.length(); i++) {
            --counts[magazine.charAt(i) - 'a'];
        }
        for (int count : counts) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}
