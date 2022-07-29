package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode657
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/12 10:27
 * @Version 1.0
 */
public class LeetCode657 {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = moves.toCharArray();
        boolean k;
        for (char c : chars) {
            switch (c) {
                case 'R' :
                    k = map.containsKey('L');
                    if (k) {
                        map.put('L', map.get('L') - 1);
                        if (map.get('L') == 0) map.remove('L');
                    } else {
                        map.put('R', map.getOrDefault('R', 0) + 1);
                    }
                    break;
                case 'L' :
                    k = map.containsKey('R');
                    if (k) {
                        map.put('R', map.get('R') - 1);
                        if (map.get('R') == 0) map.remove('R');
                    } else {
                        map.put('L', map.getOrDefault('L', 0) + 1);
                    }
                    break;
                case 'U' :
                    k = map.containsKey('D');
                    if (k) {
                        map.put('D', map.get('D') - 1);
                        if (map.get('D') == 0) map.remove('D');
                    } else {
                        map.put('U', map.getOrDefault('U', 0) + 1);
                    }
                    break;
                case 'D' :
                    k = map.containsKey('U');
                    if (k) {
                        map.put('U', map.get('U') - 1);
                        if (map.get('U') == 0) map.remove('U');
                    } else {
                        map.put('D', map.getOrDefault('D', 0) + 1);
                    }
                    break;
            }
        }
        if (map.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean judgeCircle1(String moves) {
        int x = 0, y = 0;
        int length = moves.length();
        for (int i = 0; i < length; i++) {
            char move = moves.charAt(i);
            if (move == 'U') {
                y--;
            } else if (move == 'D') {
                y++;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }
        return x == 0 && y == 0;
    }

    public boolean judgeCircle2(String moves) {
        //2.位图：减少判断
        int[] arr = new int[26];
        char[] chars = moves.toCharArray();
        for (char aChar : chars) arr[aChar - 'A']++;
        return  arr['R' - 'A']==arr['L' - 'A'] &&  arr['U' - 'A']==arr['D' - 'A'] ;
    }

}
