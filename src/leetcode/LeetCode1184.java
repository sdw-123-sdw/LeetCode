package leetcode;

/**
 * @ClassName LeetCode1184
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/4 10:21
 * @Version 1.0
 */
public class LeetCode1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int i = 0;
        int j = 0;
        if (destination < start) {
            start = start ^ destination;
            destination = start ^ destination;
            start = start ^ destination;
        }

        for (int i1 = 0; i1 < distance.length; i1++) {
            if (i1 >= start && i1 < destination) {
                i += distance[i1];
            } else {
                j += distance[i1];
            }
        }
        return i > j ? j : i;
    }
}
