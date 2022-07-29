package leetcode;

/**
 * @ClassName LeetCode537
 * @Description TODO
 * @Author: 索德文
 * @date 2022/2/25 15:54
 * @Version 1.0
 */
public class LeetCode537 {
    public String complexNumberMultiply(String num1, String num2) {
        // 复数乘法计算方法
        // （a+bi）（c+di） = （ac-bd）+（bc+ad）i
        String[] split = num1.split("\\+|i");
        String[] split1 = num2.split("\\+|i");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split1[0]);
        int d = Integer.parseInt(split1[1]);
        int ra = a * c - b * d;
        int rb = b * c + a * d;
        return ra  + "+" + rb + "i";
    }
}
