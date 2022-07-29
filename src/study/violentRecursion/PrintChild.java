package study.violentRecursion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName PrintChild
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/27 20:35
 * @Version 1.0
 */
public class PrintChild {
    // 当前来到i位置，要和不要，走两条路
    // res之前的选择,所形成的列表
    public void process(char[] str, int i, List<Character> res) {
        if (i == str.length) {
            res.forEach(System.out::println);
            return;
        }
        List<Character> resKeep = res.stream().collect(Collectors.toList());
        resKeep.add(str[i]);
        process(str, i + 1, resKeep); // 要当前字符的路
        List<Character> resNoInclude = res.stream().collect(Collectors.toList());
        process(str, i + 1, resNoInclude); // 不要当前字符的路
    }

    // 省空间
    public void process(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        // 要字符就留着,不要就置位0
        process(str, i + 1); // 要当前字符的路
        char tmp = str[i];
        str[i] = 0;
        process(str, i+ 1); // 不要当前字符的路
        str[i] = tmp;
    }
}
