package leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode804
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/10 8:50
 * @Version 1.0
 */
public class LeetCode804 {
    public static final String[] TABLE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            StringBuilder s = new StringBuilder();
            for (char aChar : chars) {
                s.append(TABLE[aChar - 'a']);
            }
            set.add(s.toString());
        }
        return set.size();
    }
}
