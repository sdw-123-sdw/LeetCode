package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName leetcode.LeetCode1115
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/23 9:44
 * @Version 1.0
 */
public class LeetCode1115 {
    private int n;

    public LeetCode1115(int n) {
        this.n = n;
    }

    Lock lock1 = new ReentrantLock();
    Condition condition1 = lock1.newCondition();
    Condition condition2 = lock1.newCondition();
    boolean flag = false;
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            lock1.lock();
            while (flag) {
                condition1.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = true;
            condition2.signal();
            lock1.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock1.lock();
            while (!flag) {
                condition2.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = false;
            condition1.signal();
            lock1.unlock();
        }
    }

    public static void main(String[] args) {
        LeetCode1115 leetCode1115 = new LeetCode1115(100);
        try {
            leetCode1115.foo(new Runnable() {
                @Override
                public void run() {
                    System.out.print("foo");
                }
            });
            leetCode1115.bar(new Runnable() {
                @Override
                public void run() {
                    System.out.println("bar");
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
