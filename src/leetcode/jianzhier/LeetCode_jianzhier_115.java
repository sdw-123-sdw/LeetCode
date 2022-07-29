package leetcode.jianzhier;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_jianzhier_115
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/23 9:54
 * @Version 1.0
 */
public class LeetCode_jianzhier_115 {
    // 使用拓扑排序，就是有向图那个
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int l = nums.length;
        // 用来记录每个数的入度，0号下标作废
        int[] ans = new int[l + 1];
        // 用来记录每个节点的指向的是哪个，0号下标作废
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= l; i++) {
            list.add(new ArrayList<>());
        }
        // 计算入度，并且将每个节点的指向节点进行放入
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                ans[sequence[i]]++;
                list.get(sequence[i - 1]).add(sequence[i]);
            }
        }
        // 0不用，是从[1,n]
        int cut = 0;
        // 寻找头节点
        for (int i = 0; i <= l; i++) {
            // 先判断入度是否为0
            if (ans[i] == 0) {
                // 判断在此之前，是不是已经有节点入度为0了，如果有了，证明头节点不唯一，返回false
                if (cut == 0) {
                    cut = i;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < l; i++) {
            // 判断是否和原序列对应节点相等
            if (nums[i] != cut) {
                return false;
            }
            // 对其指向的后继节点进行入度减一操作
            List<Integer> list1 = list.get(cut);
            int flag = 0;
            for (Integer j : list1) {
                // 入度减一后是否入度为0
                if (--ans[j] == 0) {
                    // 在此之前是否有入度为0的节点，如果有，证明后继节点不唯一，返回false
                    if (flag == 0) {
                        flag = j;
                    } else {
                        return false;
                    }
                }
            }
            cut = flag;
        }
        return true;
    }
}
