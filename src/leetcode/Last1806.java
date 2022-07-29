package leetcode;

/**
 * @ClassName leetcode.Last1806
 * @Description TODO
 * @Author: 索德文
 * @date 2021/9/19 21:46
 * @Version 1.0
 */
public class Last1806 {
    public static void main(String[] args) {
        M m = new M();
        int a = m.A(20);
        System.out.println(a);
//        new leetcode.M().as();
    }


}

class M {
    int count = 0;
    public int A(int n) {
        if(n == 2) {
            return ++count;
        } else if (n == 4) {
            return count = count + 2;
        }
        int[] m = new int[n];
        while (true) {
            for (int i = 0; i < n; i++) {
                if(count == 0) {
                    if(i % 2 == 0) {
                        m[i] = i / 2;
                    } else {
                        m[i] = n / 2 + (i - 1) / 2;
                    }
                } else {
                    if(m[i] % 2 == 0) {
                        m[i] = m[i] / 2;
                    } else {
                        m[i] = n / 2 + (m[i] - 1) / 2;
                    }
                }
            }
            count++;
            if((m[0] + 2) == m[1] ? ((m[1] + 2) == m[2] ? true : false) : false) {
                count++;
                break;
            }
        }
        return count;
    }
}
