package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode1333
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/6 16:15
 * @Version 1.0
 */
public class LeetCode1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Map<Integer, TreeSet<Integer>> map = new TreeMap<>((a, b) -> b - a);
        for (int i = 0; i < restaurants.length; i++) {
            int[] restaurant = restaurants[i];
            if ((veganFriendly == 0 || restaurant[2] == veganFriendly) && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                if (map.containsKey(restaurant[1])) {
                    map.get(restaurant[1]).add(restaurant[0]);
                } else {
                    TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
                    set.add(restaurant[0]);
                    map.put(restaurant[1], set);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            TreeSet<Integer> integers = map.get(integer);
            for (Integer integer1 : integers) {
                list.add(integer1);
            }
        }
        return list;
    }
}
