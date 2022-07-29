package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode467
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/25 9:16
 * @Version 1.0
 */
public class LeetCode467 {
    /*
    由于 s 是周期字符串，对于在 s 中的子串，只要知道子串的第一个字符（或最后一个字符）和子串长度，就能确定这个子串。例如子串以 ‘d’ 结尾，长度为 3，那么该子串为 “bcd”。
    题目要求不同的子串个数，那么对于两个以同一个字符结尾的子串，长的那个子串必然包含短的那个。例如 “abcd” 和 “bcd” 均以 ‘d’ 结尾，“bcd” 是 “abcd” 的子串。
    据此，我们可以定义 dp[α] 表示 p 中以字符 α 结尾且在 s 中的子串的最长长度，知道了最长长度，也就知道了不同的子串的个数。
    如何计算 dp[α] 呢？我们可以在遍历 p 时，维护连续递增的子串长度 k。具体来说，遍历到 p[i] 时，如果 p[i] 是 p[i−1] 在字母表中的下一个字母，则将 k 加一，否则将 k 置为 1，表示重新开始计算连续递增的子串长度。
    然后，用 k 更新 dp[p[i]] 的最大值。
    遍历结束后，p 中以字符 c 结尾且在 s 中的子串有 dp[c] 个。例如 dp[‘d’]=3 表示子串 “bcd”、“cd” 和 “d”。
    最后答案为 所有的和
     */
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (i > 0 && (p.charAt(i - 1) + 1) % 26 == c % 26) {
                k++;
            } else {
                k = 1;
            }
            dp[c - 'a'] = Math.max(dp[c - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }

    public int findSubstringInWraproundString2(String p) {
        int[] records = new int[26];
        int last = -1, max = 0;
        char[] cs = p.toCharArray();
        for (char c : cs) {
            int cur = c - 'a';
            max = (cur == last + 1) || (last == 25 && cur == 0) ? max + 1 : 1;
            if (max > records[cur]) {
                records[cur] = max;
            }
            last = cur;
        }
        int ans = 0;
        for (int num : records) {
            ans += num;
        }
        return ans;
    }
}
