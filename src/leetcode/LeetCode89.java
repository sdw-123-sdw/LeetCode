package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode89
 * @Description TODO
 * @Author: 索德文
 * @date 2022/1/8 10:24
 * @Version 1.0
 */
public class LeetCode89 {
    /*
    设 nn 阶格雷码集合为 G(n)G(n)，则 G(n+1)G(n+1) 阶格雷码为：给 G(n)G(n) 阶格雷码每个元素二进制形式前面添加 00，得到 G'(n)G′(n)；
    设 G(n)G(n) 集合倒序（镜像）为 R(n)R(n)，给 R(n)R(n) 每个元素二进制形式前面添加 11，得到 R'(n)R′(n)；
    G(n+1) = G'(n) ∪ R'(n)G(n+1)=G′(n)∪R′(n) 拼接两个集合即可得到下一阶格雷码。
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}
