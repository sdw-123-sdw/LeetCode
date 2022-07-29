package leetcode;

/**
 * @ClassName LeetCode933
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/6 10:58
 * @Version 1.0
 */
public class LeetCode933 {
    int calls[] = new int[10005];
    int p;
    public LeetCode933() {
        p = 0;
    }

    public int ping(int t) {
        calls[p] = t;
        p++;
        int l = 0, r = p - 1;
        while(l < r){
            int mid = (l + r) >> 1;
            if(calls[mid] < t - 3000) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
            if(l == r - 1) {
                if(calls[l] >= t - 3000) {
                    r = l;
                }
                break;
            }
        }
        return p - r;
    }
}
