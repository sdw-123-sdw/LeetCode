package study.violentRecursion;

/**
 * @ClassName Hannoi
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/27 20:23
 * @Version 1.0
 */
public class Hannoi {
    public void hanoi(int i) {
        if (i > 0) {
            func(i, "左", "右", "中");
        }
    }

    public void func(int i, String start, String end, String other) {
        if (i == 1) {
            System.out.println("把 1 从" + start + "到" + end);
        } else {
            func(i - 1, start, other, end); // 从start挪到other上，end是另外一个
            System.out.println("把" + i + "从" + start + "移动到" + end);
            func(i - 1, other, end, start);
        }
    }
}
