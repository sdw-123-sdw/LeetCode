package weeklyEvents;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName week_7_24_001
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/24 10:31
 * @Version 1.0
 */
public class week_7_24_001 {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        for (char c1 : c) {
            if (set.contains(c1)) {
                return c1;
            } else {
                set.add(c1);
            }
        }
        return 'a';
    }
}
