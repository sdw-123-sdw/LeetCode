package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode.LeetCode638
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/24 20:06
 * @Version 1.0
 */
public class LeetCode638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int min = needs.get(0);
        int i = 0;
        for (int i1 = 0; i1 < price.size(); i1++) {
            min = Math.max(min, needs.get(i1));
            if(price.get(i1) == 0) {
                i++;
            }
        }
        if(i == price.size()) {
            return 0;
        }
        if(min == 0) {
            return 0;
        }
        i = 0;
        while (i < special.size()){
            for(int j = 0; j < price.size(); j++) {
                if(special.get(i).get(j) > needs.get(j)) {
                    special.remove(i);
                    break;
                }
                if(j == (price.size() - 1)) {
                    i++;
                }
            }
        }
        min = Integer.MAX_VALUE;
        int[] m = new int[needs.size()];
        for (int z = 0; z < needs.size(); z++) {
            m[z] = needs.get(z);
        }
        int compare = compare(min, m, special, 0, price);
        return compare;
    }

    /**
     *
     * @param min 此时的最小值
     * @param z 此时的需求数组
     * @param special 去多后的礼包集合
     * @param sum 当前价格和
     * @return
     */
    private int compare(int min, int[] z, List<List<Integer>> special, int sum, List<Integer> price) {
        boolean flag = true;
        for(int i = 0; i < special.size(); i++) {
            boolean o = flag;
            boolean count = false;
            for (int j = 0; j < z.length; j++) {
                if(special.get(i).get(j) > z[j]) {
                    count = true;
                    break;
                }
            }
            if (count) {
                continue;
            }
            int[] m = new int[z.length];
            for (int j = 0; j < z.length; j++) {
                m[j] = z[j] - special.get(i).get(j);
                flag  = false;
            }
            if(i != 0 && !o) {
                sum = sum + special.get(i).get(special.get(i).size() - 1) - special.get(i - 1).get(special.get(i).size() - 1);
            } else {
                sum = sum + special.get(i).get(special.get(i).size() - 1);
            }
            min = compare(min, m, special, sum, price);
        }
        if (flag) {
            // 计算
            for (int i = 0; i < z.length; i++) {
                sum = sum + z[i] * price.get(i);
            }
            min = Math.min(min, sum);
        }

        return min;
    }

    public static void main(String[] args) {
        LeetCode638 leetCode638 = new LeetCode638();
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(3);
//        List<List<Integer>> special = new ArrayList<Integer>{{3, 0, 5}, {1, 2, 10}};
        List<List<Integer>> special = Arrays.asList(Arrays.asList(1, 0, 1), Arrays.asList(0, 1, 2));
        List<Integer> needs = Arrays.asList(1, 1);
        System.out.println(leetCode638.shoppingOffers(price, special, needs));
    }
}
