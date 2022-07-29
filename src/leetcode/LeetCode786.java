package leetcode;

import java.util.*;

/**
 * @ClassName leetcode.LeetCode786
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/29 9:31
 * @Version 1.0
 */
public class LeetCode786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> map = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                map.add(new int[]{arr[i], arr[j]});
            }
        }
        map.sort(((o1, o2) -> o1[1] * o2[0] - o1[0]*o2[1]));
        return map.get(k - 1);
    }

    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (double)o2[0]/o2[1] - (double) o1[0]/o1[1] > 0 ? -1 : 1);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                queue.add(new int[]{arr[i], arr[j]});
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            ++i;
            if (i == k) {
                return queue.poll();
            }
            queue.poll();
        }
        return null;
    }

    /*-------------------------------------leetcode解法-----------------------------------*/
    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        double l=0;
        double r=1;
        while (l<r){
            double mid=(l+r)/2;
            int[] num=find(arr,mid);
            if(num[2]==k){
                return new int[]{num[0],num[1]};
            }else if(num[2]>k){
                r=mid;
            }else {
                l=mid;
            }
            //System.out.println(mid);
            //System.out.println(num[2]);
        }
        return new int[0];
    }
    int[] find(int[] arr,double x){
        int i=-1;
        int cnt=0;
        int a=arr[0];
        int b=arr[arr.length-1];
        for(int j=1;j<arr.length;j++){
            while (i<j-1&&arr[i+1]<x*arr[j]){
                i++;
            }
            cnt+=i+1;
            if(i>=0&&arr[i]*b>arr[j]*a){
                a=arr[i];
                b=arr[j];
            }
        }
        return new int[]{a,b,cnt};
    }
}
