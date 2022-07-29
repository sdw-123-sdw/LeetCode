package study.violentRecursion;

/**
 * @ClassName WeightAndValue
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/28 14:47
 * @Version 1.0
 */
public class WeightAndValue {
    // weights[0...i - 1]已经选好了要或者不要了
    // 只能看weights[i....]后面的要或者不要
    // values价值
    public int process1(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max(
                process1(weights, values, i + 1, alreadyWeight, bag),
                alreadyWeight + weights[i] > bag ? 0 : values[i] + process1(weights, values, i + 1, alreadyWeight + weights[i], bag)
        );
    }
}
