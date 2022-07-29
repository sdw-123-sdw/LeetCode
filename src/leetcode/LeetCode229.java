package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode.LeetCode229
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/22 9:21
 * @Version 1.0
 */
public class LeetCode229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return list;
        }
        int majority1 = Integer.MIN_VALUE;
        int majority2 = Integer.MIN_VALUE;
        int countMajority1 = 0;
        int countMajority2 = 0;
        for (int num : nums) {
            if(countMajority1 == 0 || countMajority2 == 0) {
                if(num != majority1 && num != majority2) {
                    if(countMajority1 == 0) {
                        majority1 = num;
                        countMajority1++;
                    } else {
                        majority2 = num;
                        countMajority2++;
                    }
                } else if(num == majority1) {
                    countMajority1++;
                } else {
                    countMajority2++;
                }
            } else {
                if(num != majority1 && num != majority2) {
                    countMajority1--;
                    countMajority2--;
                } else if(num == majority1){
                    countMajority1++;
                } else {
                    countMajority2++;
                }
            }
        }

        if(countMajority1 < 1 && countMajority2 < 1) {
            return list;
        } else {
            countMajority1 = 0;
            countMajority2 = 0;
            for (int num : nums) {
                if(num == majority1) {
                    countMajority1++;
                }
                if(num == majority2) {
                    countMajority2++;
                }
            }
            if(countMajority1 <= (nums.length / 3)) {
                countMajority1 = 0;
            }
            if(countMajority2 <= (nums.length / 3)) {
                countMajority2 = 0;
            }
        }
        if(countMajority1 != 0) {
            list.add(majority1);
        }
        if(countMajority2 != 0) {
            list.add(majority2);
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode229 leetCode229 = new LeetCode229();
        List<Integer> list = leetCode229.majorityElement(new int[]{-1, -1, -1});
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
