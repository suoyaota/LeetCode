package practice.solution.P600;



/**
 * @Author William Wang
 * @Date 2020/7/26
 */
public class P617 {
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

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode temp = new TreeNode(-1);
        temp.left = mergeTrees(t1.left, t2.left);
        temp.right = mergeTrees(t1.right, t2.right);
        temp.val = t1.val + t2.val;
        return temp;
    }

}
