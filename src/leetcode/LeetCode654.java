package leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode654
 * @Description TODO
 * @Author: 索德文
 * @date 2022/7/4 10:44
 * @Version 1.0
 */
public class LeetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // return swap(nums);
        return construct(nums, 0, nums.length);
    }

    private TreeNode swap(int[] nums) {
        if (nums.length == 0) return null;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                count = i;
            }
        }
        TreeNode root = new TreeNode(max);
        if (count > 0) {
            root.left = swap(Arrays.copyOfRange(nums, 0, count));
        } else {
            root.left = swap(Arrays.copyOfRange(nums, 0, 0));
        }
        if (count < nums.length - 1) {
            root.right = swap(Arrays.copyOfRange(nums, count + 1, nums.length));
        } else {
            root.right = swap(Arrays.copyOfRange(nums, nums.length - 1, nums.length - 1));
        }
        return root;
    }

    public TreeNode construct(int[] nums,int l,int r) {
        if(l>=r){
            return null;
        }
        int max=0;
        int rootGps=0;
        for(int i=l;i<r;i++){
            if(nums[i]>=max){
                max=nums[i];
                rootGps=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=construct(nums,l,rootGps);
        root.right=construct(nums,rootGps+1,r);
        return root;
    }

    public static void main(String[] args) {
        LeetCode654 leetCode654 = new LeetCode654();
        TreeNode treeNode = leetCode654.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        leetCode654.print(treeNode);
    }

    private void print(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
}
