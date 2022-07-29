package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leetcode.LeetCode677
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/14 11:15
 * @Version 1.0
 */
class TrieNode {
    char key = ' ';
    int value = 0;
    TrieNode[] tries = new TrieNode[26];
}
public class LeetCode677 {
    //
//    leetcode.TrieNode tries = new leetcode.TrieNode();
//    public leetcode.LeetCode677() {
//    }
//
//    public void insert(String key, int val) {
//        leetcode.TrieNode trie = tries.;
////        leetcode.TrieNode trie = new leetcode.TrieNode();
//        trie = tries[(key.charAt(0) - 'a')];
//        for (int i = 0; i < key.length(); i++) {
//            if(i != 0) {
//                trie = trie.tries[(key.charAt(i) - 'a')];
//            }
//            trie.key = key.charAt(i);
////            if(i == key.length() - 1) {
//                trie.value += val;
////            }
//            trie.tries = new leetcode.TrieNode[26];
//        }
//    }
//
//    public int sum(String prefix) {
//        leetcode.TrieNode trie = tries[0];
//        trie = tries[(prefix.charAt(0) - 'a')];
//        for (int i = 1; i < prefix.length(); i++) {
//            trie = trie.tries[(prefix.charAt(i) - 'a')];
//        }
//        int sum = 0;
//        for (int i = 0; i < 26; i++) {
//            sum += trie.tries[i].value;
//        }
//        return sum;
//    }
    class TrieNode {
        int val = 0;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root;
    Map<String, Integer> map;

    public LeetCode677() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
            node.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return 0;
            }
            node = node.next[c - 'a'];
        }
        return node.val;
    }
}

class Test {
    public static void main(String[] args) {
        LeetCode677 leetCode677 = new LeetCode677();
        leetCode677.insert("apple", 3);
        System.out.println(leetCode677.sum("ap"));
        leetCode677.insert("app", 2);
        System.out.println(leetCode677.sum("ap"));
    }
}
