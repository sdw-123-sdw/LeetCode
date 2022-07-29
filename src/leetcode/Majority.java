package leetcode; /**
 * @ClassName leetcode.Majority
 * @Description 摩尔投票法
 * @Author: 索德文
 * @date 2021/10/22 9:22
 * @Version 1.0
 */

/**
 * 摩尔投票法：
 * 寻找当前数组中数量超过1/2的数
 * 思路：一个数组中数量超过1/2的个数如果有那么只能有一个
 * 摩尔投票法：每次选出两个不同的进行删除，那么最后如果有剩下那么一定是目标值
 * 本题思路：维护一个变量记录当前的值，一次遍历，如果相同那么就+1代表存储下来，如果不同，那么当前值-1，最后如果有剩下那么就是目标值
 */
public class Majority {
    public int majorityElement(int[] nums) {
        int majority = -1;   // 标志量
        int count = 0;       // 统计当前标志量的个数
        for (int num : nums) {
            if(count == 0) {
                count++;
                majority = num;
            } else {
                if(majority == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        int counter = 0;
        if (count <= 0) {
            return -1;
        } else {
            for (int num : nums) {
                if (num == majority) counter ++;
            }
        }

        if (counter > nums.length / 2) {
            return majority;
        }

        return -1;
    }
}
