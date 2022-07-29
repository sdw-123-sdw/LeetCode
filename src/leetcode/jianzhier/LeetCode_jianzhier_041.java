package leetcode.jianzhier;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LeetCode_jianzhier_041
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/16 1:23
 * @Version 1.0
 */
public class LeetCode_jianzhier_041 {
    double sum = 0;
    int size;
    // List<Integer> list;
    Queue<Integer> queue;
    public LeetCode_jianzhier_041(int size) {
        // list = new LinkedList<>();
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        // if (list.size() == size) {
        //     sum -= list.remove(0);
        // }
        // list.add(val);
        // sum += val;
        // return sum / list.size();
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
