package study.violentRecursion;

/**
 * @ClassName IntegerToString
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/28 11:38
 * @Version 1.0
 */
public class IntegerToString {
    // i之前的位置，如何转化已经做过决定了
    // i... 有多少种转化的结果
    public int process(char[] str, int i) {
        if (i == str.length) {
            // 只有一种转化结果
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1); // 让i自己作为单独的一部分，后续有多少种方式
            if (i + 1 < str.length) {
                res += process(str, i + 2); // 让i和i+1作为一部分，后续有多少种
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1); // 让i自己作为单独的一部分，后续有多少种方式
            if (i + 1 < str.length && (str[i + 1] >= 0 && str[i + 1] < '7')) { // 当i+1没有超过数组最大长度，并且i和i+1组成的数没有超过26，就让i和i+1作为一部分，后续有多少种
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str, i + 1);
    }
}
