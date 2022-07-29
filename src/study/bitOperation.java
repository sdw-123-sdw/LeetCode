package study;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @ClassName bitOperation
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/7 9:17
 * @Version 1.0
 */
public class bitOperation {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 取反
        int a = 5;
        System.out.println(a);
        System.out.println(-a);
        System.out.println(~a);
        // 00101  ->  11010  ->  11011
        System.out.println(~a + 1);

        // 负数
        // 正数变负数符号位是1，然后值是后面的按位取反再+1
        // 负数值怎么算?除去符号位剩下按位取反再+1

        // >> 是带符号右移，也就是负数右移一位还是最高位用1补全原本符号位右移
        // >>> 是不带符号右移
        String str = "data1";
        String str2 = new String("data2");
        StringBuffer buffer = new StringBuffer("data3");
        System.out.println("!!!!!1 str:=" + str + " str2:=" + str2
                + " buffer:=" + buffer.toString());
        dealData(str, str2, buffer);
        System.out.println("!!!!!2 str:=" + str + " str2:=" + str2 + " buffer:=" + buffer.toString());
    }
    private static void dealData(String str, String str2, StringBuffer buffer) {
        str += "123";
        str2 += "123";
        buffer.append("123");
        System.out.println("nerborn: str:=" + str + " str2:=" + str2 + " buffer:=" + buffer.toString());
    }
}
class Student {
    Integer id;
    String name;
    Integer age;
}
