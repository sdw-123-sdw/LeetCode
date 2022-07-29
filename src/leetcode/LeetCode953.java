package leetcode;

/**
 * @ClassName LeetCode953
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/17 10:38
 * @Version 1.0
 */
public class LeetCode953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ints = new int[26];
        int l = order.length();
        for (int i = 0; i < l; i++) {
            ints[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean flag = false;
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int c1 = ints[words[i - 1].charAt(j) - 'a'];
                int c2 = ints[words[i].charAt(j) - 'a'];
                if (c1 < c2) {
                    flag = true;
                    break;
                } else if (c1 > c2) {
                    return false;
                }
            }
            if (!flag) {
                if (words[i].length() < words[i - 1].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
