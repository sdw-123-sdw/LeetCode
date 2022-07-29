package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @ClassName LeetCode2034
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/23 9:03
 * @Version 1.0
 */
public class LeetCode2034 {
    TreeMap<Integer, Integer> priceFreq = new TreeMap<> ();
    HashMap<Integer, Integer> timePrice = new HashMap<>();
    int curTime = 0;
    public LeetCode2034() {

    }
    public void update(int timestamp, int price) {
        if (timestamp > curTime) {
            curTime = timestamp;
        }
        int toUpdate = timePrice.getOrDefault(timestamp, -1);
        if (priceFreq.containsKey(toUpdate)) {
            priceFreq.put(toUpdate, -1 + priceFreq.get(toUpdate));
            if (priceFreq.get(toUpdate) == 0) {
                priceFreq.remove(toUpdate);
            }
        }
        timePrice.put(timestamp, price);
        priceFreq.put(price, 1 + priceFreq.getOrDefault(price, 0));
    }
    public int current() {
        return timePrice.get(curTime);
    }
    public int maximum() {
        return priceFreq.floorKey(Integer.MAX_VALUE);
    }
    public int minimum() {
        return priceFreq.ceilingKey(-1);
    }
}
