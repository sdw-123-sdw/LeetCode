package leetcode;

/**
 * @ClassName LeetCode1154
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/21 8:57
 * @Version 1.0
 */
public class LeetCode1154 {
    public int dayOfYear(String date) {
        int[] ints = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");
        for (String s : split) {
            System.out.println(s);
        }
        int data = 0;
        int i = Integer.parseInt(split[0]);
        if (Integer.parseInt(split[1]) > 2 && (i % 400 == 0 || (i % 4 == 0 && i % 100 > 0))) ++data;
        for (int i1 = 0; i1 < Integer.parseInt(split[1]); i1++) {
            data += ints[i1];
        }
        return data + Integer.parseInt(split[2]);
    }

    public static void main(String[] args) {
        LeetCode1154 leetCode1154 = new LeetCode1154();
        leetCode1154.dayOfYear("2000-03-17");
    }
}
