package leetcode;

import java.util.*;

/**
 * @ClassName LeetCode735
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/13 9:45
 * @Version 1.0
 */
public class LeetCode735 {
    public int[] asteroidCollision(int[] asteroids) {
        // List<Integer> list = new ArrayList<>();
        // int l = asteroids.length;
        // int i = 1;
        // int count = 1;
        // list.add(asteroids[0]);
        // while (i < l && count > 0) {
        //     int j = list.get(count - 1).intValue();
        //     if (asteroids[i] * j < 0) {
        //         if (Math.abs(asteroids[i]) > Math.abs(j)) {
        //             list.remove(count - 1);
        //             count--;
        //         } else if (Math.abs(asteroids[i]) == Math.abs(j)){
        //             list.remove(count - 1);
        //             count--;
        //             i++;
        //         } else {
        //             i++;
        //         }
        //         if (count == 0 && i < l - 1) {
        //             list.add(asteroids[i]);
        //             count++;
        //             i++;
        //         }
        //     } else {
        //         list.add(asteroids[i]);
        //         count++;
        //         i++;
        //     }
        // }
        // while (i < l) {
        //     if (asteroids[i] > 0) {
        //         list.add(asteroids[i]);
        //         i++;
        //         count++;
        //         continue;
        //     }
        //     int j = list.get(count - 1).intValue();
        //     if (j < 0) {
        //         list.add(asteroids[i]);
        //         i++;
        //         count++;
        //         continue;
        //     }
        //     // 前正后负
        //     int h = asteroids[i] + j;
        //     if (h < 0) {
        //         list.remove(count - 1);
        //         count--;
        //     } else if (h == 0){
        //         list.remove(count - 1);
        //         count--;
        //         i++;
        //         if (count == 0 && i < l - 1) {
        //             list.add(asteroids[i]);
        //             count++;
        //             i++;
        //         }
        //         continue;
        //     } else {
        //         i++;
        //         continue;
        //     }
        //     if (count == 0) {
        //         list.add(asteroids[i]);
        //         count++;
        //         i++;
        //     }
        // }
        // int[] size = new int[count];
        // for (int i1 = 0; i1 < count; i1++) {
        //     size[i1] = list.get(i1);
        // }
        // return size;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode735 leetCode735 = new LeetCode735();
        int[] ints = leetCode735.asteroidCollision(new int[]{1, -1, 1, -2});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
