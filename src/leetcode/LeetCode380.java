package leetcode;

import jdk.nashorn.internal.ir.IfNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName LeetCode380
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/13 14:35
 * @Version 1.0
 */
public class LeetCode380 {
    Map<Integer, Integer> map = new HashMap<>(); // 前面存数字，后面存对应数组下标
    int[] number = new int[200000];
    int have = -1; // 表示现在有多少个元素，同时表示数组中最后一个值得下标
    Random random = new Random();
    public LeetCode380() {

    }

    public boolean insert(int val) {
        boolean b = map.containsKey(val);
        if (!b) {
            map.put(val, ++have);
            number[have] = val;
            return true;
        }
         return false;
    }

    public boolean remove(int val) {
        Integer remove = map.remove(val);
        if (remove == null) {
            return false;
        }
        if (remove != have) map.put(number[have], remove);
        number[remove] = number[have--];
        return true;
    }

    public int getRandom() {
        return number[random.nextInt(have + 1)];
    }

    public static void main(String[] args) {
        LeetCode380 leetCode380 = new LeetCode380();
        System.out.println(leetCode380.insert(1));
        System.out.println(leetCode380.remove(2));
        System.out.println(leetCode380.insert(2));
        System.out.println(leetCode380.getRandom());
        System.out.println(leetCode380.remove(1));
        System.out.println(leetCode380.insert(2));
        System.out.println(leetCode380.getRandom());
    }
}
