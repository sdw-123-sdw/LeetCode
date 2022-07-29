package leetcode;

import java.util.TreeMap;

/**
 * @ClassName LeetCode729
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/5 12:25
 * @Version 1.0
 */
public class LeetCode729 {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public LeetCode729() {
        map.put(-1,-1);
        map.put((int)1e9+1,(int)1e9+1);
    }

    public boolean book(int start, int end) {
        Integer a=map.ceilingKey(start);//右边
        Integer b=map.floorKey(start);//左边
        if(a<end||map.get(b)>start){
            return false;
        }
        map.put(start,end);
        return true;
    }
}
