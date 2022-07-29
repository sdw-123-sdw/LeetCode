package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode691
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/14 9:59
 * @Version 1.0
 */
public class LeetCode691 {
    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int[] memo = new int[1 << m];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int res = dp(stickers, target, memo, (1 << m) - 1);
        return res <= m ? res : -1;
    }

    public int dp(String[] stickers, String target, int[] memo, int mask) {
        int m = target.length();
        if (memo[mask] < 0) {
            int res = m + 1;
            for (String sticker : stickers) {
                int left = mask;
                int[] cnt = new int[26];
                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a']++;
                }
                for (int i = 0; i < target.length(); i++) {
                    char c = target.charAt(i);
                    if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                        cnt[c - 'a']--;
                        left ^= 1 << i;
                    }
                }
                if (left < mask) {
                    res = Math.min(res, dp(stickers, target, memo, left) + 1);
                }
            }
            memo[mask] = res;
        }
        return memo[mask];
    }

    public int minStickers2(String[] stickers, String target) {
        if (stickers == null || target == null) {
            return -1;
        }
        int len = stickers.length;
        int[][] count = new int[len][26];
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String s = stickers[i];
            for (char c : s.toCharArray()) {
                count[i][c - 'a']++;
                if (!map.containsKey(c)) {
                    map.put(c, new HashSet<>());
                }
                map.get(c).add(i);
            }
        }
        int lent = target.length();
        int inf = (int)1e9;
        int[] f = new int[1 << lent];
        for (int i = 0; i < f.length; i++) {
            f[i] = inf;
        }
        f[0] = 0;
        for (int i = 0; i < (1 << lent) - 1; i++) {
            if (f[i] == inf) continue;
            int ci = -1;
            for (int j = 0; j < lent; j++) {
                if (((1 << j) & i) == 0) {
                    ci = j;
                    break;
                }
            }
            if (ci == -1) break;
            char c = target.charAt(ci);
            if (!map.containsKey(c)) {
                return -1;
            }
            Set<Integer> set = map.get(c);
            for (int ni : set) {
                int[] cnt = new int[26];
                for (int j = 0; j < 26; j++) {
                    cnt[j] = count[ni][j];
                }
                int nextState = i;
                for (int j = 0; j < lent; j++) {
                    if (((1 << j) & i) == 0) {
                        if (cnt[target.charAt(j) - 'a'] > 0) {
                            cnt[target.charAt(j) - 'a']--;
                            nextState |= (1 << j);
                        }
                    }
                }
                f[nextState] = Math.min(f[nextState], f[i] + 1);
            }
        }
        return f[(1 << lent) - 1];
    }
}
