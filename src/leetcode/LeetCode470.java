package leetcode;

import java.util.Random;

/**
 * @ClassName LeetCode470
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/17 15:14
 * @Version 1.0
 */
/*
    rand7()是题目中已经实现可以随机生成1~7的随机数
 */
public class LeetCode470 {
//    public int rand10() {
//        do {
//            /*
//                此处 + 号前后的两个事件是独立事件，互不干扰，且前后的值生成的都是可以保证每个值出现的概率相同
//                (rand7() - 1)：生成0~6的随机数
//                (rand7() - 1) * 7：在上一个基础上进行乘除并不会改变概率，生成的数都是7的倍数
//                (rand7() - 1) * 7 + rand7()：在上一个基础上，将中间空的7个数进行填充。，可以随机生成0~49的随机数
//                对于返回值，舍弃大于40的数
//             */
//            int random = (rand7() - 1) * 7 + rand7();
//            if (random <= 40) return random % 10 + 1;
//            /*
//                承接上文，这里将舍弃的数利用起来，也就是41~49，- 40 - 1后的值为0~8,
//                * 7后依旧是7的倍数，中间空着7个数，rand7()将中间空缺的数进行填充
//                可以生成0~63的随机数，这时只需要舍弃3个数即可，意味着循环次数减少
//             */
//            random = (random - 40 - 1) * 7 + rand7();
//            if (random <= 60) return random % 10 + 1;
//            /*
//                承接上文，这里将舍弃的61~63利用起来，可以生成0~21的随机数，这时只需要舍去1个数即可
//                循环次数再次减少，每次循环只舍弃21即可
//             */
//            random = (random - 20 - 1) * 7 + rand7();
//            if (random <= 20) return random % 10 + 1;
//        } while (true);
//    }

//    public static void main(String[] args) {
//        LeetCode470 leetCode470 = new LeetCode470();
//        System.out.println(leetCode470.rand10());
//    }
}
