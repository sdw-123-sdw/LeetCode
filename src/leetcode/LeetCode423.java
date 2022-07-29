package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode.LeetCode423
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/24 9:23
 * @Version 1.0
 */
public class LeetCode423 {
    public String originalDigits(String s) {
        // ["0e","1g","2f","3i","4h","5o","6n","7s","8r","9u","10t","11w","12v","13x","14z"]
        // z：代表0，g：代表8，u：代表4，w：代表2，x：代表6
        int[] ints = new int[15];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'z' :
                    --ints[0];
                    --ints[8];
                    --ints[5];
                    ++ints[14];
                    break;
                case 'w' :
                    --ints[10];
                    --ints[5];
                    ++ints[11];
                    break;
                case 'g' :
                    --ints[0];
                    --ints[3];
                    ++ints[1];
                    --ints[4];
                    --ints[10];
                    break;
                case 'u' :
                    --ints[2];
                    --ints[5];
                    ++ints[9];
                    --ints[8];
                    break;
                case 'x' :
                    --ints[7];
                    --ints[3];
                    ++ints[13];
                    break;
                default:
                    // 1 9 11 13 14
                    // ["0e","1g","2f","3i","4h","5o","6n","7s","8r","9u","10t","11w","12v","13x","14z"]
                    if (c == 'e') ++ints[0];
                    else if (c == 'f') ++ints[2];
                    else if (c == 'i') ++ints[3];
                    else if (c == 'h') ++ints[4];
                    else if (c == 'o') ++ints[5];
                    else if (c == 'n') ++ints[6];
                    else if (c == 's') ++ints[7];
                    else if (c == 'r') ++ints[8];
                    else if (c == 't') ++ints[10];
                    else ++ints[12];
            }
        }
        // 完成上一遍for后
        // f：代表5，s代表7，h：代表3，o：代表1，但是5要将所有的i减去，剩下i为9
        // 2,7,4,5,3
        ints[3] = ints[3] - ints[2];
        StringBuffer string = getString(ints[14], '0');
        string.append(getString(ints[5], '1'));
        string.append(getString(ints[11], '2'));
        string.append(getString(ints[4], '3'));
        string.append(getString(ints[9], '4'));
        string.append(getString(ints[2], '5'));
        string.append(getString(ints[13], '6'));
        string.append(getString(ints[7], '7'));
        string.append(getString(ints[1], '8'));
        string.append(getString(ints[3], '9'));
        return string.toString();
    }

    private StringBuffer getString(int i, char a) {
        StringBuffer s = new StringBuffer("");
        for (int i1 = 0; i1 < i; i1++) {
            s.append(a);
        }
        return s;
    }

    public String originalDigits2(String s) {
        char[] count = new char[26 + (int) 'a'];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        List<Character> characters =  Arrays.asList('z', 'w', 'u', 'x', 'g');

        int[] out = new int[10];
        for (int i = 0, flag = 0; i < out.length; i += 2) {
            out[i] = count[characters.get(flag)];
            flag++;
        }
        // letter "h" is present only in "three" and "eight"
        out[3] = count['h'] - out[8];
        // letter "f" is present only in "five" and "four"
        out[5] = count['f'] - out[4];
        // letter "s" is present only in "seven" and "six"
        out[7] = count['s'] - out[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'] - out[7] - 2 * out[9];

        // building output string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < out[i]; j++)
                output.append(i);
        return output.toString();
    }

    public static void main(String[] args) {
        LeetCode423 leetCode423 = new LeetCode423();
        System.out.println(leetCode423.originalDigits("fviefuro"));
    }
}
