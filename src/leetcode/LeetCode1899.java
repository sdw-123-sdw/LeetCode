package leetcode;

/**
 * @ClassName LeetCode1899
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/18 9:40
 * @Version 1.0
 */
public class LeetCode1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        return swap(triplets, target, 0) && swap(triplets, target, 1) && swap(triplets, target, 2);
    }

    private boolean swap(int[][] triplets, int[] target, int k) {
        for (int[] triplet : triplets) {
            if (triplet[k] == target[k] && triplet[(k + 1) % 3] <= target[(k + 1) % 3] && triplet[(k + 2) % 3] <= target[(k + 2) % 3]) {
                return true;
            }
        }
        return false;
    }
}
