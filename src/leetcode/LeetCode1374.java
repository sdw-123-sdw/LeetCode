package leetcode;

/**
 * @ClassName LeetCode1374
 * @Description TODO
 * @Author: 索德文
 * @date 2022/6/8 22:15
 * @Version 1.0
 */
public class LeetCode1374 {
    public String generateTheString(int n) {
        StringBuilder s = new StringBuilder();
        if (n % 2 == 0) {
            s.append("a");
            int l = n - 1;
            for (int i = 0; i < l; i++) {
                s.append("b");
            }
        } else {
            for (int i = 0; i < n; i++) {
                s.append("a");
            }
        }
        return s.toString();
    }
}

class Foo implements Runnable {
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
