package leetcode;

/**
 * @ClassName leetcode.LeetCode492
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/23 9:36
 * @Version 1.0
 */
public class LeetCode492 {
    public int[] constructRectangle(int area) {
        int i = (int) Math.sqrt(area);
        while (area % i != 0) {
            i--;
        }
        return new int[]{area / i, i};
    }

    public static void main(String[] args) {
        LeetCode492 leetCode492 = new LeetCode492();
        int[] ints = leetCode492.constructRectangle(15);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
