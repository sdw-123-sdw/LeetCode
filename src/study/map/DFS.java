package study.map;

import java.util.HashSet;
import java.util.Stack;

/**
 * @ClassName DFS
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/22 16:48
 * @Version 1.0
 */
public class DFS {
    public void dfs(Node node) {
        if(node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet();  // 控制不要重复访问
        stack.push(node);
        set.add(node);
        // 处理操作
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if(!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    // 处理操作
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
