package leetcode;

/**
 * @ClassName LeetCode450
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/2 10:18
 * @Version 1.0
 */
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (root.val == key) {
                    return null;
                }
            } else {
                return dfs(root, key);
            }
        }
        return root;
    }

    // 如果左边上去，那么原来的右枝一右到底
    // 如果右边上去，那么原来二左枝一左到底
    private TreeNode dfs(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.right != null && root.left == null) {
                return root.right;
            } else if (root.left != null && root.right != null) {
                return swap(root.left, root.right);
            } else if (root.left == null && root.right == null) {
                return null;
            }
        }
        if (key < root.val) {
            root.left = dfs(root.left, key);
        } else {
            root.right = dfs(root.right, key);
        }
        return root;
    }

    private TreeNode swap(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return root1;
        }
        root2.left = swap(root1, root2.left);
        return root2;
    }

    // 法二
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode t = root.right;
            while (t.left != null) t = t.left;
            t.left = root.left;
            return root.right;
        } else if (root.val < key) root.right = deleteNode(root.right, key);
        else root.left = deleteNode(root.left, key);
        return root;
    }

    public static void main(String[] args) {
        LeetCode450 leetCode450 = new LeetCode450();
        TreeNode root = new TreeNode(5, null, new TreeNode(7, new TreeNode(6, new TreeNode(5, null, null), null), new TreeNode(8, null, new TreeNode(9, null, null))));
        leetCode450.deleteNode(root, 7);
    }
}
