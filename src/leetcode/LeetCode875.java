package leetcode;

/**
 * @ClassName LeetCode875
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/8 15:41
 * @Version 1.0
 */
public class LeetCode875 {
    /*
    简单使用二分查找，上限是香蕉堆数的最大值，下限是1，找到最适合的时间即可
     */
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        if (h == piles.length) return max;
//        int max = 1_000_000_000;
        int start = 1;
        while (start < max) {
            int i = (max + start) >> 1;
            boolean swap = swap(piles, i, h);
            if (!swap) {
                max = i;
            } else {
                start = i + 1;
            }
        }
        return start;
    }

    private boolean swap(int[] target, int nowTime, int h) {
        int time = 0;
        for (int i : target) {
            time += (i + nowTime - 1) / nowTime; // (i - 1) / nowTime + 1
        }
        return time > h;
    }

    public static void main(String[] args) {
        LeetCode875 leetCode875 = new LeetCode875();
        System.out.println(leetCode875.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}
