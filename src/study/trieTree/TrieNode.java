package study.trieTree;

/**
 * @ClassName TrieNode
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/24 20:56
 * @Version 1.0
 */
public class TrieNode {
    public int pass; // 该节点通过了多少次
    public int end; // 该节点是否是一个字符串的结尾节点,如果是的话,他是多少个字符串的结尾节点
    // 若是字符种类很多，可以使用哈希结构代替数组 HashMap<Char, TrieNode> nexts;表示某个字符对应的下级节点
    // 若是不希望他是散的,想要他是有序的,那么可以使用有序表代替 TreeMap<Char, TrieNode> nexts;
    public TrieNode[] nexts;

    public TrieNode() {
        pass = 0;
        end = 0;
        // nexts[0] == null  没有走向'a'的路
        // nexts[0] != null  有走向'a'的路
        // ...
        // nexts[25] != null  有走向'z'的路
        nexts = new TrieNode[26];
    }
}
