import javax.swing.tree.TreeNode;

/**
 * @Date 2019/10/9 18:22
 * @Author William Wang
 */
public class P112 {
    class Solution {
        int nowSum = 0;
        boolean ans = false;

        public boolean hasPathSum(TreeNode root, int sum) {
            Search(root, sum);
            return ans;
        }

        public void Search(TreeNode treeNode, int sum) {
            if (ans == true || treeNode == null) {
                return;
            }
            nowSum += treeNode.val;
            Search(treeNode.left, sum);
            Search(treeNode.right, sum);
            if (treeNode.left == null && treeNode.right == null && nowSum == sum) {
                ans = true;
            }
            nowSum -= treeNode.val;
        }

    }

}
