package practice.solution;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wyb
 */
@Component
public class P95 {
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

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<TreeNode>();
        }
        return generateSubTrees(1, n);
    }

    private List<TreeNode> generateSubTrees(int s, int e) {
        List<TreeNode> tree = new LinkedList<TreeNode>();
        if (s > e) {
            tree.add(null);
            return tree;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> l = generateSubTrees(s, i - 1);
            List<TreeNode> r = generateSubTrees(i + 1, e);
            for (TreeNode lt : l) {
                for (TreeNode rt : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    tree.add(root);
                }
            }
        }
        return tree;

    }
}

