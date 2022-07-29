package study.violentRecursion;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;

/**
 * @ClassName FullArrangement
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/27 21:11
 * @Version 1.0
 */
public class FullArrangement {
    /*
    可以使用这种,后面有//的,也可以使用不去重,然后得到所有结果之后进行sort排序再去重,但是这样的话会全走一边,过程中去重可以在常数上进行优化
    提前去重的方法叫做“分支限界”，提前将枝剪掉
     */
    // chs[i..]范围上,所有的字符,都可以在i位置上,后续都去尝试
    // chs[0..i-1]范围上,是之前做的选择
    // res是生成的结果
    public void process(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
        }
        // 查看当前字符是否试过了,若是试过了则跳过,否则进入尝试,适用场景假如abcaer,有重复字符
        boolean[] visit = new boolean[26];  //
        for (int j = i; j < chs.length; j++) {
            if (!visit[chs[j] - 'a']) {  //
                visit[chs[j] - 'a'] = true;  //
                swap(chs, i, j);
                process(chs, i + 1, res);
                swap(chs, i, j);
            }  //
        }
    }

    public void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
