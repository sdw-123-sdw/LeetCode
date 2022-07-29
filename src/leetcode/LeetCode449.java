package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode449
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/11 10:12
 * @Version 1.0
 */
public class LeetCode449 {
    public String serialize(TreeNode root) {
        if (root == null) return null;
        List<String> list = new ArrayList<>();
        dfs1(root, list);
        int n = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
            if (i != n - 1) sb.append(",");
        }
        return sb.toString();
    }
    void dfs1(TreeNode root, List<String> list) {
        if (root == null) return ;
        list.add(String.valueOf(root.val));
        dfs1(root.left, list);
        dfs1(root.right, list);
    }
    public TreeNode deserialize(String s) {
        if (s == null) return null;
        String[] ss = s.split(",");
        return dfs2(0, ss.length - 1, ss);
    }
    // 每次找出该节点的左右子树区间
    TreeNode dfs2(int l, int r, String[] ss) {
        if (l > r) return null;
        int j = l + 1, t = Integer.parseInt(ss[l]);
        TreeNode ans = new TreeNode(t);
        while (j <= r && Integer.parseInt(ss[j]) <= t) j++;
        ans.left = dfs2(l + 1, j - 1, ss);
        ans.right = dfs2(j, r, ss);
        return ans;
    }
}
