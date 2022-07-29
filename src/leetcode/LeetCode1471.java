package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode1471
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/30 16:41
 * @Version 1.0
 */
public class LeetCode1471 {
    public int[] getStrongest(int[] arr, int k) {
        if (arr.length == k) return arr;
        int[] ints = new int[k];
        Arrays.sort(arr);
        int l = arr.length;
        int m = (l - 1)>> 1;
        int i = arr[m];
        int start = 0;
        int end = l - 1;
        for (int z = 0; z < k; z++) {
            int j = Math.abs(arr[start] - i) - Math.abs(arr[end] - i);
            if (j > 0) {
                ints[z] = arr[start];
                start++;
            } else if (j < 0) {
                ints[z] = arr[end];
                end--;
            } else {
                if (arr[start] > arr[end]) {
                    ints[z] = arr[start];
                    start++;
                } else {
                    ints[z] = arr[end];
                    end--;
                }
            }
        }
        return ints;
    }

    public int[] getStrongest1(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int mid = arr[(n-1)/2];
        int l = 0, r = n-1;
        int idx = 0;
        int[] res = new int[k];
        while(--k>=0){
            if(arr[r]-mid>=mid-arr[l]){
                res[idx++] = arr[r--];
            }else{
                res[idx++] = arr[l++];
            }
        }
        return res;
    }
}
