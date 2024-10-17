package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author wyb
 * @date 2020/7/23
 */
@Component
public class P104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
