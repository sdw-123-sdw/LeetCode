package leetcode;

/**
 * @ClassName LeetCode35
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/6 8:47
 * @Version 1.0
 */
public class LeetCode35 {
    // 二分查找
    public int searchInsert(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        int mid = 0;
        while (start < end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start] < target ? start + 1 : start;
    }
}
