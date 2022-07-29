package leetcode;

/**
 * @ClassName LeetCode1185
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/3 9:46
 * @Version 1.0
 */
public class LeetCode1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] s = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = 4;
        for (int i = 1971; i < year; i++) {
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            ans += isLeap ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            ans += nums[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) ans++;
        }
        ans += day;
        return s[ans % 7];
    }
}
