package leetcode;

/**
 * @ClassName LeetCode1530
 * @Description TODO
 * @Author: 索德文
 * @date 2022/4/8 17:40
 * @Version 1.0
 */

public class LeetCode1530 {
    int res = 0;
    public int countPairs(TreeNodes root, int distance) {
        dfs(root,distance);
        return res;
    }

    private int[]  dfs(TreeNodes root, int distance){
        if(root == null){
            return new int[distance+1];
        }
        int[] count = new int[distance+1];
        if(root.left==null&&root.right==null){
            //这里将到当前节点的距离为0的节点个数设为1，即它本身
            count[0] = 1;
            return count;
        }
        int[] leftCount = dfs(root.left,distance);
        int[] rightCount = dfs(root.right,distance);
        //m，n分别为叶子节点到当前节点的距离，那么m-1,n-1分别是叶子节点到当前节
        //点的左右子节点的距离。
        for(int m =1; m<=distance;m++){
            for(int n=1; n<=distance-m;n++){
                res += leftCount[m-1]*rightCount[n-1];
            }
        }
        //由于加入了距离为0,所以这里得从1开始向上构造
        for(int i=1;i<=distance;i++){
            count[i]=leftCount[i-1]+rightCount[i-1];
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1530 leetCode1530 = new LeetCode1530();
        System.out.println(leetCode1530.countPairs(new TreeNodes(1, new TreeNodes(2, new TreeNodes(4, null, null), new TreeNodes(5, null, null)), new TreeNodes(3, new TreeNodes(6, null, null), new TreeNodes(7, null, null))), 3));
    }

}
class TreeNodes {
    int val;
    TreeNodes left;
    TreeNodes right;

    TreeNodes() {
    }

    TreeNodes(int val) {
        this.val = val;
    }

    TreeNodes(int val, TreeNodes left, TreeNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
