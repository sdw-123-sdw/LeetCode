package leetcode;

/**
 * @ClassName leetcode.LeetCode397
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/19 9:29
 * @Version 1.0
 */
public class LeetCode397 {
    public int integerReplacement(int n) {
        long temp = n;
        short count = 0;
        while(temp != 1){
            if((temp & 3) == 3 && temp != 3){
                temp++;
            }
            else if((temp & 1) == 1){
                temp--;
            }
            else{
                temp = temp >> 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode397 leetCode397 = new LeetCode397();
        System.out.println(leetCode397.integerReplacement(65535));
    }
}
