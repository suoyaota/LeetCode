import javax.swing.tree.TreeNode;

/**
 * @author wyb
 * @date 2020/7/28
 */
public class P101 {
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
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymTree(root.left, root.right);
        }
        private boolean isSymTree(TreeNode a, TreeNode b) {
            if (a == null && b == null) {
                return true;
            }
            if (a == null || b == null) {
                return false;
            }
            if (a.val != b.val) {
                return false;
            }
            return isSymTree(a.left, b.right) && isSymTree(a.right, b.left);
        }
    }
}
