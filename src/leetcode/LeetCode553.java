package leetcode;

/**
 * @ClassName LeetCode553
 * @Description TODO
 * @Author: 索德文
 * @date 2022/2/27 18:40
 * @Version 1.0
 */
public class LeetCode553 {
    public String optimalDivision(int[] nums) {
        // 不管怎么样，第一个都是分子，分子是不能变大的，所以只需要让分母变得尽可能小，所以只需要让第二个数不断地除即可
        int length = nums.length;
        if (length == 1) return nums[0] + "";
        if (length == 2) return nums[0] + "/" + nums[1];
        String s = "";
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                s = s + nums[i];
            } else if (i == 1){
                s = s + "/" + "(" + nums[i];
            } else {
                s = s + "/" + nums[i];
            }
        }
        return s + ")";
    }

    // 时间快，占用内存小
    public String optimalDivision1(int[] nums) {
        // 不管怎么样，第一个都是分子，分子是不能变大的，所以只需要让分母变得尽可能小，所以只需要让第二个数不断地除即可
        StringBuilder sb = new StringBuilder();
        int len = nums.length;
        if(len == 1) return sb.append(nums[0]).toString();
        if(len == 2) return sb.append(nums[0]).append("/").append(nums[1]).toString();
        sb.append(nums[0]).append("/(");
        int i = 1;
        while(i < nums.length-1) {
            sb.append(nums[i++]).append("/");
        }
        sb.append(nums[i]).append(")");
        return sb.toString();
    }

}
