import javax.swing.tree.TreeNode;

/**
 * @Date 2019/10/9 18:21
 * @Author William Wang
 */
public class P111 {
    class Solution {
        int ans = Integer.MAX_VALUE;
        int anst = 0;

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            search(root,anst);
            return ans;

        }

        public void search(TreeNode node, int anst){
            if(node == null){
                return;
            }
            anst++;
            //操作
            search(node.left,anst);
            search(node.right,anst);
            if(node.left == null && node.right == null && anst < ans) ans = anst;
            anst --;
        }
    }

}
