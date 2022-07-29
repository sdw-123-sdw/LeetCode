package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName LeetCode506
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/2 9:04
 * @Version 1.0
 */
public class LeetCode506 {
    public String[] findRelativeRanks(int[] score) {
        String name[] = {"", "Gold Medal", "Silver Medal", "Bronze Medal"};
        int n = score.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < n; i++) {
            pq.add(new int[]{score[i], i});
        }
        String res[] = new String[n];
        for(int i = 1; i <= n; i++) {
            int temp[] = pq.poll();
            if(i < 4) {
                res[temp[1]] = name[i];
            } else {
                res[temp[1]] = String.valueOf(i);
            }
        }
        return res;
    }

    public String[] findRelativeRanks1(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        int max = 0;
        // 找出找出最高的成绩
        for (int num : score) {
            if (max < num) {
                max = num;
            }
        }
        // 下标为成绩，值为成绩在 nums 数组的下标
        int[] array = new int[max + 1];
        for (int i = 0; i < n; i++) {
            array[score[i]] = i + 1;
        }
        // 记录当前成绩的排名
        int count = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                // 根据排名进行赋值
                switch (count) {
                    case 1:
                        result[array[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        result[array[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        result[array[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        result[array[i] - 1] = String.valueOf(count);
                }
                count++;
            }
        }
        return result;
    }
}
