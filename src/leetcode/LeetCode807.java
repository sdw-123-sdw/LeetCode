package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode807
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/13 8:37
 * @Version 1.0
 */
public class LeetCode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] level = new int[grid.length];
        int[] high = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid.length; i1++) {
                level[i] = Math.max(level[i], grid[i][i1]);
                high[i1] = Math.max(high[i1], grid[i][i1]);
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid.length; i1++) {
                sum += Math.min(level[i], high[i1]) - grid[i][i1];
            }
        }
        return sum;
    }

    public void test1(int[] arr) {
        int pri1 = 0, pri2 = arr.length - 1;
        int left = 0, right = arr.length - 1, k = 1;
        if (arr[pri1] > arr[pri2]) {
            arr[0] = arr[0] ^ arr[arr.length - 1];
            arr[1] = arr[0] ^ arr[arr.length - 1];
            arr[0] = arr[0] ^ arr[arr.length - 1];
        }
        while(k != right) {
            if (arr[k] < arr[pri1]) {
                left++;
                int tmp = 0;
                tmp = arr[left];
                arr[left] = arr[k];
                arr[k] = tmp;
                k++;
            } else if (arr[k] >= arr[pri1] && arr[k] <= arr[pri2]) {
                k++;
            } else if (arr[k] > arr[pri2]){
                right--;
                int tmp = 0;
                tmp = arr[k];
                arr[k] = arr[right];
                arr[right] = tmp;
            }
        }
        int tmp = 0;
        tmp = arr[left];
        arr[left] = arr[pri1];
        arr[pri1] = tmp;

        tmp = arr[right];
        arr[right] = arr[pri2];
        arr[pri2] = tmp;
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 6, 8 ,4, 5, 2, 8, 5, 15, 225};
        LeetCode807 leetCode807 = new LeetCode807();
        leetCode807.test1(arr);
    }
}
