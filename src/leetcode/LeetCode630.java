package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @ClassName LeetCode630
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/14 10:12
 * @Version 1.0
 */
public class LeetCode630 {
    // 使用贪心，按照完成时间进行排序
    /*
    首先
    1. 判断上课时间是否比截止时间大，若是大，则根本可能上这节课
    2. 按照结束时间进行排序，因为肯定优先结束时间靠前的要先上
    3. 若是当前已经上了课的时间加上将要上的时间比将要上的这节课的截止时间小，直接上
    4. 若是大，则判断已经上的课中，上课时间最长的那节课的上课时间是否比将要上的这节课时间长，若是将要上的这节课比它小或者等于都替换，因为在上课时间相等甚至小的情况下，将要上的这节课把最大结束时间延后了
        也就是说，原来是[100, 110]，允许上课时间是[0,110]，但是这节课是[100, 200]，允许上课时间就变到[0, 200]而且上课时间占得可能还小
        ps：不需要担心替换后的这节课时间会超时，首先允许上课的时间扩大了，并且这节课的上课时长又小于等于要删的课时长，所以一定能放下，而且空闲时间有长了好多。
        例如，现在已经上课的时间为100, 而最大结束时间是110，其中最大上课时间为[20, 50]，现在新来的这节课[15, 200]，让最大结束时间变为200，而已经上课的时间变为95，甚至比原来还小。
     */
    public int scheduleCourse(int[][] courses) {
        int now = 0; // 当前时间
        PriorityQueue<Integer> bigQueue = new PriorityQueue<>(new BigCompare());
        Arrays.sort(courses, new SmallCompare());
        for (int i = 0; i < courses.length; i++) {
            if (courses[i][0] > courses[i][1]) {
                continue;
            }
            int[] poll = courses[i];
            if (now + poll[0] <= poll[1]) {
                bigQueue.add(poll[0]);
                now += poll[0];
            } else if (bigQueue.peek() >= poll[0]){
                now = now - bigQueue.poll() + poll[0];
                bigQueue.add(poll[0]);
            }
        }
        return bigQueue.size();
    }
    // 比较器
    public class SmallCompare implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    }

    public class BigCompare implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
