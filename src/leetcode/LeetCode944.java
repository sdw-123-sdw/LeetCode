package leetcode;

/**
 * @ClassName LeetCode944
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/12 9:04
 * @Version 1.0
 */
public class LeetCode944 {
    public int minDeletionSize(String[] strs) {
        int length = strs.length;
        int l = strs[0].length();
        int count = 0;
        for (int i = 0; i < l; i++) {
            char flag = 'a';
            for (int j = 0; j < length; j++) {
                char c = strs[j].charAt(i);
                if (c < flag) {
                    count++;
                    break;
                }
                flag = c;
            }
        }
        return count;
    }
}
