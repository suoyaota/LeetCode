
import java.util.ArrayList;
import java.util.List;

/**
 * @author wyb
 * @date 2020/7/31
 */
public class P94 {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return ans;
            }
            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);
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
//    class Solution {
//        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> ans = new ArrayList<>();
//            if (root == null) {
//                return ans;
//            }
//            Stack<TreeNode> stack = new Stack<>();
//            TreeNode cur = root;
//            while (cur != null || !stack.isEmpty()) {
//                while (cur != null) {
//                    stack.push(cur);
//                    cur = cur.left;
//                }
//                TreeNode node = stack.pop();
//                ans.add(node.val);
//                cur = node.right;
//            }
//            return ans;
//        }
//    }
}
