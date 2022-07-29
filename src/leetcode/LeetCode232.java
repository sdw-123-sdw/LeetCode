package leetcode;

import java.util.Stack;

/**
 * @ClassName LeetCode232
 * @Description TODO
 * @Author: 索德文
 * @date 2021/12/16 20:11
 * @Version 1.0
 */
public class LeetCode232 {
    Stack<Integer> stackPush = new Stack<>();
    Stack<Integer> stackPop = new Stack<>();
    public LeetCode232() {

    }

    public void push(int x) {
        while (!stackPop.isEmpty()) {
            stackPush.push(stackPop.pop());

        }
        stackPop.push(x);
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
    }

    public int pop() {
        return stackPop.pop();
    }

    public int peek() {
        return stackPop.peek();
    }

    public boolean empty() {
        return stackPop.isEmpty();
    }
}
