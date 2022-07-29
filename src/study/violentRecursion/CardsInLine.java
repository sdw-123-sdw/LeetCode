package study.violentRecursion;

/**
 * @ClassName CardsInLine
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/28 10:49
 * @Version 1.0
 */
public class CardsInLine {
    public int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        // 我拿走i，剩下数我后手
        return Math.max(arr[i] + s(arr, i + 1, j), arr[i] + s(arr, i, j - 1));
    }

    public int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }
}
