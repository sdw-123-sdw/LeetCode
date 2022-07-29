package weeklyEvents;

import java.util.Arrays;

/**
 * @ClassName week_7_10_001
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/10 11:38
 * @Version 1.0
 */
public class week_7_10_001 {
    // 6112
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int sum = 0;
        if ((amount[2] - (amount[1] + amount[0])) > 0) {
            return amount[2];
        }
        while (true) {
            if (amount[2] == 0) {
                return sum;
            }
            amount[2]--;
            amount[1]--;
            sum++;
            Arrays.sort(amount);
        }
    }
}
