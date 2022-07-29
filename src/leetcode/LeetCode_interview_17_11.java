package leetcode;

/**
 * @ClassName LeetCode_interview_17_11
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/27 8:23
 * @Version 1.0
 */
public class LeetCode_interview_17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        int length = words.length;
        int start = 0;
        String startString = null;
        int min = 1000001;
        for (int i = 0; i < length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (startString != null) {
                    if (!startString.equals(words[i])) {
                        min = Math.min(i - start, min);
                        startString = words[i];
                    }
                } else {
                    startString = words[i];
                }
                start = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode_interview_17_11 leetCode_interview_17_11 = new LeetCode_interview_17_11();
        System.out.println(leetCode_interview_17_11.findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }
}
