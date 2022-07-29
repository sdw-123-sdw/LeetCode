package leetcode;

import java.util.*;

/**
 * @ClassName leetcode.SumOfSuccessiveSubarrays
 * @Description TODO 连续的子数组之和
 * TODO 加和之后若余数相同，则说明x-y处是一个符合要求的数组
 * @Author: 索德文
 * @date 2021/6/2 20:15
 * @Version 1.0
 */
public class SumOfSuccessiveSubarrays {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length <= 1) return false;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == 0 && nums[i + 1] == 0){
                return true;
            }
        }
        if(k == 0) return false;

        Map<Object, Integer> map = new HashMap();  //用来存放每次的余数
        int sum = 0;
        map.put(0, -1);  //将-1位置设置为余数为零，方便判断第一个数
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            int n = sum % k;
            if(map.containsKey(n)) {
                if((i - map.get(n)) > 1) {
                    return true;
                }
            }
            else {
                map.put(n, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println("i % 0 = " + 0 % i);
    }
}
