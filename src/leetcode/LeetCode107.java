package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LeetCode107
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/19 17:06
 * @Version 1.0
 */
public class LeetCode107 {
    // 广搜
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 0 is queue,1 is queue1
        int flag = 0;
        queue.add(root);
        List<Integer> list1 = new ArrayList<>();
        while (!queue.isEmpty() || !queue1.isEmpty()) {
            TreeNode poll;
            if (flag == 0) {
                poll = queue.poll();
            } else {
                poll = queue1.poll();
            }
            list1.add(poll.val);
            if (poll.left != null) {
                if (flag == 0) {
                    queue1.add(poll.left);
                } else {
                    queue.add(poll.left);
                }
            }
            if (poll.right != null) {
                if (flag == 0) {
                    queue1.add(poll.right);
                } else {
                    queue.add(poll.right);
                }
            }
            if (flag == 0) {
                if (queue.isEmpty()) {
                    flag = 1;
                    list.add(0, list1);
                    list1 = new ArrayList<>();
                }
            } else {
                if (queue1.isEmpty()) {
                    flag = 0;
                    list.add(0, list1);
                    list1 = new ArrayList<>();
                }
            }
        }
        return list;
    }

    // 方法二：也是广搜
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        dfs(root,0);
        int size = res.size();
        for(int i = 0;i < size;i ++){
            reverse.add(res.get(size - i - 1));
        }
        return reverse;
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<List<Integer>> reverse = new ArrayList<List<Integer>>();

    public List<List<Integer>> dfs(TreeNode node,int depth){
        if(node == null) return res;
        depth++;

        if(res.size() < depth){
            List<Integer> item = new ArrayList<>();
            res.add(item);
        }

        res.get(depth - 1).add(node.val);
        dfs(node.left,depth);
        dfs(node.right,depth);
        return res;
    }

    // 方法三：还是广搜，但是是最佳
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> curList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curList.add(curNode.val);
                if(curNode.left != null) {
                    queue.add(curNode.left);
                }
                if(curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            ans.add(0, curList);
        }
        return ans;
    }
}
