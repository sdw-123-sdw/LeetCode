package leetcode;

import java.util.HashMap;

/**
 * @ClassName LeetCode357
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/11 9:04
 * @Version 1.0
 */
public class LeetCode357 {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static {
        map.put(0, 1);
        map.put(1, 10);
        for (int i = 2; i < 10; i++) {
            int count = 1;
            for (int i1 = 0; i1 < i; i1++) {
                if (i1 == 0) count = count * 9;
                else count = count * (10 - i1);
            }
            map.put(i, count + map.get(i - 1));
        }
    }
    public int countNumbersWithUniqueDigits(int n) {
        return map.get(n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(map.get(i));
        }
    }
}
