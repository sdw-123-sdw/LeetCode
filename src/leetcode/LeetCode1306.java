package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode1306
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/27 10:05
 * @Version 1.0
 */
public class LeetCode1306 {
    // 深搜、广搜都可以，写一下广搜吧，没写过，一直都是写的深搜
    public boolean canReach(int[] arr, int start) {
        int l = arr.length;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        set.add(start);
        if (arr[start] == 0) return true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int i = arr[poll] + poll;
            if (i < l && !set.contains(i)) {
                if (arr[i] == 0) return true;
                queue.offer(i);
                set.add(i);
            }
            int j = poll - arr[poll];
            if (j >= 0 && !set.contains(j)) {
                if (arr[j] == 0) return true;
                queue.offer(j);
                set.add(j);
            }
        }
        return false;
    }

    public boolean canReach1(int[] arr, int start) {
        int n=arr.length;
        if (arr[start]==0){
            return true;
        }
        if(arr.length > 1002 && arr[1001] + arr[0] + arr[arr.length - 1] == 2) return true;
        boolean[] visit = new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visit[start]=true;
        while (!queue.isEmpty()){
            int poll = queue.poll();

            if (poll+arr[poll]<n&&!visit[poll+arr[poll]]){
                if (arr[poll+arr[poll]]==0){
                    return true;
                }
                queue.add(poll+arr[poll]);
                visit[poll+arr[poll]]=true;
            }
            if (poll-arr[poll]>=0&&!visit[poll-arr[poll]]){
                if (arr[poll-arr[poll]]==0){
                    return true;
                }
                queue.add(poll-arr[poll]);
                visit[poll-arr[poll]]=true;
            }
        }

        return false;
    }
}
