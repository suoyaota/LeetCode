package practice.solution.P600;



/**
 * @Author William Wang
 * @Date 2020/7/30
 */
public class P671 {
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

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.right == null) {
            return -1;
        }
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) {
            //问题向左子树传递，右子树不传递
            leftVal = findSecondMinimumValue(root.left);
        }
        if (rightVal == root.val) {
            //问题向右子树传递
            rightVal = findSecondMinimumValue(root.right);
        }
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }
        if (leftVal != -1) {
            return leftVal;
        }
        return rightVal;
    }
}

