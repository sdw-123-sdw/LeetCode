package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode1305
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/1 15:51
 * @Version 1.0
 */
public class LeetCode1305 {
    List<Integer> list = new ArrayList<>();
    int count = 0;
    // 方法一：使用中序遍历+归并排序
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            if (root2 != null) {
                swap(root2);
                return list;
            }
        } else {
            if (root2 == null) {
                swap(root1);
                return list;
            }
        }
        swap(root1);
        dfs(root2);
        return list;
    }

    private void swap(TreeNode root) {
        if (root == null) return;
        swap(root.left);
        list.add(root.val);
        swap(root.right);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        int size = list.size();
        while (count < size && root.val >= list.get(count)) {
            ++count;
        }
        list.add(count, root.val);
        dfs(root.right);
    }

    // 方法二：利用栈，实现两个在遍历的同时就进行归并排序
    LinkedList<Integer> queue = new LinkedList<>();
    List<Integer> res = new ArrayList<>();

    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        return stack(root1, root2);
    }

    public List<Integer> stack(TreeNode root1, TreeNode root2) {
        inOrder(root1, 0);
        inOrder(root2, 1);
        res.addAll(queue);
        return res;
    }

    public void inOrder(TreeNode root, int n) {
        if (root == null) return;
        inOrder(root.left,n);
        if (n == 0) queue.offer(root.val);
        if (n == 1) {
            while (!queue.isEmpty() && queue.peek() <= root.val) {
                res.add(queue.poll());
            }
            res.add(root.val);
        }
        inOrder(root.right, n);
    }
}
