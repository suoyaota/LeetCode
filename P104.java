import javax.swing.tree.TreeNode;

/**
 * @author wyb
 * @date 2020/7/23
 */
public class P104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
