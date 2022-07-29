package leetcode;

/**
 * @ClassName leetcode.DeleteDuplicateItemsInArray
 * @Description TODO 删除数组中重复项
 * @Author: 索德文
 * @date 2021/6/11 10:10
 * @Version 1.0
 */
public class DeleteDuplicateItemsInArray {
    public static int removeDuplicates(int[] nums) {

        int slow = 0;

        if(nums.length == 0) {
            return slow;
        }

        for(int quit = 0; quit < nums.length - 1; quit++) {
            if(nums[quit + 1] != nums[quit]) {
                nums[slow + 1] = nums[quit + 1];
                slow++;
            }
        }
        return ++slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int i = removeDuplicates(nums);
        System.out.println("i = " + i);
        for (int j = 0; j < i; j++) {
            System.out.println("nums[" + j + "] = " + nums[j]);
        }

    }
}
