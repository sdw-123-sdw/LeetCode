package leetcode;

/**
 * @ClassName LeetCode676
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/11 9:31
 * @Version 1.0
 */
public class LeetCode676 {
    /*
    使用字典树进行实现，
    root的26个数组空挂第一个字母，然后向下
     */
    Tire root;
    public LeetCode676() {
        root = new Tire();
    }

    public void buildDict(String[] dictionary) {
        // 构建字典树
        for (int i = 0; i < dictionary.length; i++) {
            Tire flag = root;
            for (int i1 = 0; i1 < dictionary[i].length(); i1++) {
                char c = dictionary[i].charAt(i1);
                int i2 = c - 'a';
                if (flag.child[i2] == null) {
                    flag.child[i2] = new Tire();
                }
                flag = flag.child[i2];
            }
            flag.isFinish = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Tire node, int news, boolean isModified) {
        if (news == searchWord.length()) {
            return isModified && node.isFinish;
        }
        int i = searchWord.charAt(news) - 'a';
        // 首先应该判断对应位置上有没有值
        if (node.child[i] != null) {
            if (dfs(searchWord, node.child[i], news + 1, isModified)) {
                return true;
            }
        }
        if (!isModified) {
            for (int i1 = 0; i1 < node.child.length; i1++) {
                if (i1 == i || node.child[i1] == null) continue;
                if (dfs(searchWord, node.child[i1], news + 1, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    class Tire {
        boolean isFinish;
        Tire[] child;

        public Tire() {
            isFinish = false;
            child = new Tire[26];
        }
    }

    public static void main(String[] args) {
        LeetCode676 leetCode676 = new LeetCode676();
        leetCode676.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(leetCode676.search("hello"));
        System.out.println(leetCode676.search("hhllo"));
        System.out.println(leetCode676.search("hell"));
        System.out.println(leetCode676.search("leetcoded"));
    }
}
