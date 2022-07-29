package leetcode;

/**
 * @ClassName leetcode.LeetCode367
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/4 14:28
 * @Version 1.0
 */
public class LeetCode367 {
    public boolean isPerfectSquare(int num) {
        if(num == 0) return true;
        int left = 1;
        int right = num;
        while (left <= right) {
            int i = (right - left) / 2 + left;
            if((long)i * i == num) {
                return true;
            } else if((long)i * i < num){
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare1(int num) {
        return Math.sqrt(num) == ((int)Math.sqrt(num));
    }

    public static void main(String[] args) {
        LeetCode367 leetCode367 = new LeetCode367();
        System.out.println(leetCode367.isPerfectSquare(2147483647));
        System.out.println(leetCode367.isPerfectSquare1(2147483647));
        for (int i = 0; i < Math.pow(2, 31) - 1; i++) {
            if((leetCode367.isPerfectSquare(i) == false && leetCode367.isPerfectSquare1(i) == true) || (leetCode367.isPerfectSquare(i) == true && leetCode367.isPerfectSquare1(i) == false)) {
                System.out.println("结果不正确！！！！");
                System.out.println("该数是：" + i);
                break;
            }
        }
    }
}
