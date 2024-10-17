package practice.solution;

/**
 * @author wyb
 * @date 2020/7/28
 */
public class P437 {
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

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFromRoot(root, sum);
    }

    private int pathSumFromRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == sum) {
            ret++;
        }
        return ret + pathSumFromRoot(root.left, sum - root.val) + pathSumFromRoot(root.right, sum - root.val);
    }
}

