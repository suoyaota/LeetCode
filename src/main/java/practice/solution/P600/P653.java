package practice.solution.P600;



import java.util.LinkedList;
import java.util.List;

/**
 * @Author William Wang
 */
public class P653 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new LinkedList<>();
        toNumArrays(root, nums);
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            int sum = nums.get(i) + nums.get(j);
            if (sum < k) {
                i++;
            } else if (sum == k) {
                return true;
            } else {
                j--;
            }
        }
        return false;
    }

    private void toNumArrays(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        toNumArrays(root.left, nums);
        nums.add(root.val);
        toNumArrays(root.right, nums);
    }

}
