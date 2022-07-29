package weeklyEvents;

import java.util.*;

/**
 * @ClassName week_7_24_003
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/24 10:50
 * @Version 1.0
 */
public class week_7_24_003 {
    Map<String, TreeMap<Integer, TreeSet<String>>> map = new HashMap<>();
    Map<String, String[]> maps = new HashMap<>();
    public week_7_24_003(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            // 已经有这种烹饪方式了
            if (map.containsKey(cuisines[i])) {
                TreeMap<Integer, TreeSet<String>> j = map.get(cuisines[i]);
                // 也已经有了这个平分了
                if (j.containsKey(ratings[i])) {
                    TreeSet<String> s = j.get(ratings[i]);
                    s.add(foods[i]);
                } else {
                    TreeSet<String> k = new TreeSet<>();
                    k.add(foods[i]);
                    j.put(ratings[i], k);
                }
            } else {
                TreeMap<Integer, TreeSet<String>> a = new TreeMap<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                TreeSet<String> s = new TreeSet<>();
                s.add(foods[i]);
                a.put(ratings[i], s);
                map.put(cuisines[i], a);
            }
            maps.put(foods[i], new String[]{cuisines[i], String.valueOf(ratings[i])});
        }
    }

    public void changeRating(String food, int newRating) {
        String[] s = maps.get(food);
        TreeMap<Integer, TreeSet<String>> i = map.get(s[0]);
        i.get(s[1]).remove(food);
        if (i.containsKey(newRating)) {
            i.get(newRating).add(food);
        } else {
            TreeSet<String> set = new TreeSet<>();
            set.add(food);
            i.put(newRating, set);
        }
        maps.put(food, new String[]{s[0], String.valueOf(newRating)});
    }

    public String highestRated(String cuisine) {
        Map.Entry<Integer, TreeSet<String>> i = map.get(cuisine).firstEntry();
        return i.getValue().first();
    }
}
