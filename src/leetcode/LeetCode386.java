package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode386
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/18 8:54
 * @Version 1.0
 */
public class LeetCode386 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            swap(i, n);
        }
        return list;
    }

    private void swap(int i, int n) {
        if (i > n) return;
        list.add(i);
        for (int j = 0; j < 10; j++) {
            int z = i * 10 + j;
            if (z <= n) {
                swap(z, n);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode386 leetCode386 = new LeetCode386();
        System.out.println(leetCode386.lexicalOrder(13));
    }
}
