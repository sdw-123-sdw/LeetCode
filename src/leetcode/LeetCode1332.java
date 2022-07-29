package leetcode;

/**
 * @ClassName LeetCode1332
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/22 10:00
 * @Version 1.0
 */
public class LeetCode1332 {
    /*
        「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
        「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
        「子串」：连续的，「子序列」：连续/不连续
        该题思路：因为只有ab两种字符，还是删除子序列，所以，若原字符串是回文，只需要一次删除即可，若原字符串不是回文，只需要删除2次即可，第一次删除a，第二次删除b
     */
    public int removePalindromeSub(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (j > i) {
            if (s.charAt(i) != s.charAt(j)) return 2;
            ++i;
            --j;
        }
        return 1;
    }
}
