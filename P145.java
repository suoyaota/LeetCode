import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author wyb
 * @date 2020/7/31
 */
public class P145 {
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
        List<Integer> ans = new ArrayList<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return ans;
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            ans.add(root.val);
            return ans;
        }
    }

    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) continue;
                ans.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
            Collections.reverse(ans);
            return ans;
        }
    }
}
