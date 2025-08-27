package practice.solution.P500;



/**
 * @Author William Wang
 */
public class P530 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    /**
     * 中序遍历，记录前一节点，计算所有差值。
     */
    private int ans = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        getDiff(root);
        return ans;
    }

    private void getDiff(TreeNode root) {
        if (root == null) {
            return;
        }
        getDiff(root.left);
        if (preNode != null) {
            ans = Math.min(ans, root.val - preNode.val);
        }
        preNode = root;
        getDiff(root.right);
    }

}
