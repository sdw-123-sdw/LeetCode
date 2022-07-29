package leetcode;

/**
 * @ClassName LeetCode1400
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/2 9:39
 * @Version 1.0
 */
public class LeetCode1400 {
    // 出现次数为单数的数量是否 > k
    // 因为需要构造 k 个回文子串,所以所能允许的最大单数个字母的数量为 k 个,若是超过 k 个那么剩余的无法构造回文字符串
    // 题目上说的是要用所有字符来构造,所以不存在用一部分字符构造出回文子字符串
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;
        else if (k == s.length()) return true;
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int i = aChar - 'a';
            if (arr[i] > 0) --arr[i];
            else ++arr[i];
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) ++count;
        }
        return count > k ? false : true;
    }

    public static void main(String[] args) {
        LeetCode1400 leetCode1400 = new LeetCode1400();
        System.out.println(leetCode1400.canConstruct("leetcode", 3));
    }
}
