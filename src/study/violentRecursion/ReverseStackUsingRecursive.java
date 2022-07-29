package study.violentRecursion;

import java.util.Stack;

/**
 * @ClassName ReverseStackUsingRecursive
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/28 11:11
 * @Version 1.0
 */
public class ReverseStackUsingRecursive {
    public int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }
}
