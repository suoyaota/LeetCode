package practice.solution;

/**
 * @Author William Wang
 * @Date 2020/7/29
 */
public class P687 {
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

    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        //能不能和root接上
        int lpath = root.left != null && root.left.val == root.val ? l + 1 : 0;
        int rpath = root.right != null && root.right.val == root.val ? r + 1 : 0;
        ans = Math.max(ans, lpath + rpath);
        return Math.max(lpath, rpath);
    }
}
