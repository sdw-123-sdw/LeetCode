package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode911
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/11 16:09
 * @Version 1.0
 */
public class LeetCode911 {
    /*
    该题想法，因为该题只有一次初始化，而会调用多次p，所以尽量在调用p的时候简略一点
    所以想法就是在初始化的时候就把每一个时刻的票数最大的选举人找出来并存储起来
     */
    // 存放每个时间点的最大票数人，并且只有在变更的时候才会记录
    List<int[]> list = new ArrayList<>();
    public LeetCode911(int[] persons, int[] times) {
        int var = 0; // 存储最大票数人
        // 每次加的只有当前时间的加一，所以找见最大的之后，只需要判断该值是否大于当前最大票数人，若是相等了，那么使用新的这个值作为最大票数人
        Map<Integer, Integer> map = new HashMap<>(); // 这个存储每个人的票数
        for (int i = 0; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= var) {
                var = map.get(persons[i]);
                list.add(new int[]{times[i], persons[i]});
            }
        }
    }

    public int q(int t) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = (start + end + 1) >> 1;
            if (list.get(mid)[0] > t) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return list.get(start)[1];
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();// 返回毫秒级别
        LeetCode911 leetCode911 = new LeetCode911(new int[]{0,1,1,0,0,1,0}, new int[]{0,5,10,15,20,25,30});
        long s = System.currentTimeMillis();
        System.out.println(s - l);
        leetCode911.q(3);
        l = System.currentTimeMillis();
        System.out.println(l - s);
    }
}
