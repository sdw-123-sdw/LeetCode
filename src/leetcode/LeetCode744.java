package leetcode;

/**
 * @ClassName LeetCode744
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/3 9:45
 * @Version 1.0
 */
public class LeetCode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1] || target < letters[0]) return letters[0];
        int end = letters.length;
        int start = 0;
        int number = Integer.MAX_VALUE;
        char flag = ' ';
        while (end >= start) {
            int middle = start + ((end - start) >> 1);
            if (letters[middle] > target) {
                int i = letters[middle] - target;
                if (number > i) {
                    flag = letters[middle];
                    number = i;
                }
                end = middle - 1;
            } else if (letters[middle] <= target){
                start = middle + 1;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        LeetCode744 leetCode744 = new LeetCode744();
        System.out.println(leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }
}
