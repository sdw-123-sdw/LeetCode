package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @ClassName LeetCode1189
 * @Description TODO
 * @Author: 索德文
 * @date 2022/2/13 0:39
 * @Version 1.0
 */
public class LeetCode1189 {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'b' || aChar == 'a' || aChar == 'l' || aChar == 'o' || aChar == 'n') {
                map.put(aChar, map.getOrDefault(aChar, 0) + 1);
            }
        }
        if (map.size() != 5) return 0;
        int count = Integer.MAX_VALUE;
        count = Math.min(map.get('b'), count);
        count = Math.min(map.get('a'), count);
        count = Math.min(map.get('l') >> 1, count);
        count = Math.min(map.get('o') >> 1, count);
        count = Math.min(map.get('n'), count);
        return count;
    }

    public int maxNumberOfBalloons2(String text) {
        int b=0,a=0,l=0,o=0,n=0;
        for(int i=0;i<text.length();i++){
            char c=text.charAt(i);
            switch(c){
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
                    break;
            }
        }
        l/=2;
        o/=2;
        int res= Stream.of(b,a,l,o,n).min(Integer::compareTo).get();
        return res;
    }

    public int maxNumberOfBalloons3(String text) {
        int[] counts = new int[26];
        for (char c : text.toCharArray()) {
            counts[c - 'a']++;
        }
        int max = Math.min(counts[0], counts[1]);
        max = Math.min(max, counts['l' - 'a'] / 2);
        max = Math.min(max, counts['n' - 'a']);
        max = Math.min(max, counts['o' - 'a'] / 2);
        return max;
    }

    public static void main(String[] args) {
        LeetCode1189 leetCode1189 = new LeetCode1189();
        System.out.println(leetCode1189.maxNumberOfBalloons("balon"));
    }
}
