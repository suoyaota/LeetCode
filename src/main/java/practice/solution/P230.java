package practice.solution;

import org.springframework.stereotype.Component;



/**
 * @Author William Wang
 */
@Component
public class P230 {
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
     * 中序遍历，第k次从左边返回时就是第k个最小值
     */
    private int ans = 0;
    private int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        findByRecursion(root, k);
        return ans;
    }

    private void findByRecursion(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        findByRecursion(root.left, k);
        cnt++;
        if (cnt == k) {
            ans = root.val;
        }
        findByRecursion(root.right, k);
    }



    /**
     * 递归，更快
     */
    public int kthSmallest2(TreeNode root, int k) {
        int countLeft = countNode(root.left);
        if (countLeft == k - 1) {
            return root.val;
        } else if (countLeft > k - 1) {
            return kthSmallest2(root.left, k);
        } else {
            return kthSmallest2(root.right, k - 1 - countLeft);
        }
    }

    private int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNode(root.left) + countNode(root.right);
    }
}
