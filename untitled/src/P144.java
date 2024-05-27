
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wyb
 * @date 2020/7/31
 */
public class P144 {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return ans;
            }
            ans.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return ans;
        }
    }

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
    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                if (temp != null) {
                    ans.add(temp.val);
                    stack.push(temp.right);
                    stack.push(temp.left);
                }
            }
            return ans;
        }
    }
}
