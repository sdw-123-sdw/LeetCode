package leetcode;

import java.util.*;

/**
 * @ClassName leetcode.LeetCode384
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/22 9:18
 * @Version 1.0
 */
// 洗牌算法
public class LeetCode384 {
    int[] save;
    int[] change;

    private void swap(int i, int j) {
        change[i] = change[i] ^ change[j];
        change[j] = change[i] ^ change[j];
        change[i] = change[i] ^ change[j];
    }

    public LeetCode384(int[] nums) {
        save = nums;
    }

    public int[] reset() {
        return save;
    }

    public int[] shuffle() {
        change = save.clone();
        if (change.length == 2) {
            swap(0, 1);
            return change;
        }
        Random random = new Random(change.length - 1);
        for (int i = change.length - 1; i >= 1; i--) {
            swap(i, random.nextInt(i));
        }
        return change;
    }

    // 法二
    public class LeetCode384_2 {
        List<Integer> init;
        int[] save;
        int[] change;
        public LeetCode384_2(int[] nums) {
            save = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                save[i] = nums[i];
            }
        }

        public int[] reset() {
            return save;
        }

        public int[] shuffle() {
            init = new ArrayList<>();
            for(int i=0;i<save.length;i++){
                init.add(save[i]);
            }
            change = new int[save.length];
            Random random = new Random();
            for(int i=0;i<save.length;i++){
                int j = random.nextInt(init.size());
                change[i] = init.remove(j);
            }
            return change;
        }
        }

    // 法三
    class Solution {
        List<Integer> init;
        int[] save;
        int[] change;
        public Solution(int[] nums) {
            init = new ArrayList<>();
            save = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                init.add(nums[i]);
                save[i] = nums[i];
            }
        }

        public int[] reset() {
            return save;
        }

        public int[] shuffle() {
            change = new int[save.length];
            Collections.shuffle(init);
            for(int i=0;i<save.length;i++){
                change[i] = init.get(i);
            }
            return change;
        }
    }

    public static void main(String[] args) {
        LeetCode384 leetCode384 = new LeetCode384(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(leetCode384.reset()));
        System.out.println(Arrays.toString(leetCode384.shuffle()));
        System.out.println(Arrays.toString(leetCode384.reset()));
        System.out.println(Arrays.toString(leetCode384.shuffle()));
    }
}
