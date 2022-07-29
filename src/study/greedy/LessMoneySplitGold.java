package study.greedy;

import java.util.PriorityQueue;

/**
 * @ClassName LessMoneySplitGold
 * @Description 切金条问题
 * @Author: 索德文
 * @date 2021/11/25 21:03
 * @Version 1.0
 */
public class LessMoneySplitGold {
    public int lessMoney(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (priorityQueue.size() > 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);
        }
        return sum;
    }
}
