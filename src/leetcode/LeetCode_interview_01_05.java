package leetcode;

/**
 * @ClassName LeetCode_interview_01_05
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/13 16:26
 * @Version 1.0
 */
public class LeetCode_interview_01_05 {
    // 错误，完了再想
    public boolean oneEditAway(String first, String second) {
        int l1 = first.length();
        int l2 = second.length();
        int i = l1 - l2;
        if (Math.abs(i) > 1) {
            return false;
        }
        if (l1 == 0 || l2 == 0) return true;
        char[] c1 = first.toCharArray();
        char[] c2 = second.toCharArray();
        int count = 0;
        if (i == 0) {
            // 不等
            if (!first.equals(second)) {
                for (int j = 0; j < l1; j++) {
                    if (c1[j] != c2[j]) {
                        if (count != 0) return false;
                        count++;
                    }
                }
            }
        } else {
            int start = 0;
            int end = 0;
            int max = Math.max(l1, l2);
            while (start < max) {
                if (start == l1 || end == l2) {
                    if (count == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
                if (c1[start] != c2[end]) {
                    if (count == 0) {
                        if (l1 < l2) {
                            end++;
                        } else {
                            start++;
                        }
                    } else {
                        return false;
                    }
                    count++;
                }
                start++;
                end++;
            }
        }
        return true;
    }

    public boolean oneEditAway1(String first, String second) {
        int n = first.length(), m = second.length();
        if (Math.abs(n - m) > 1) return false;
        if (n > m) return oneEditAway(second, first);
        int i = 0, j = 0, cnt = 0;
        while (i < n && j < m && cnt <= 1) {
            char c1 = first.charAt(i), c2 = second.charAt(j);
            if (c1 == c2) {
                i++; j++;
            } else {
                if (n == m) {
                    i++;
                }
                j++;
                cnt++;
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        LeetCode_interview_01_05 leetCode_interview_01_05 = new LeetCode_interview_01_05();
        System.out.println(leetCode_interview_01_05.oneEditAway("", "b"));
    }
}
