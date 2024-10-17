package practice.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyb
 */
public class P501 {
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

    private int maxCnt = 1;
    private int tempCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        getAnsList(root, ansList);
        int[] ans = new int[ansList.size()];
        int idx = 0;
        for (Integer i : ansList) {
            ans[idx++] = i;
        }
        return ans;
    }

    private void getAnsList(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }
        getAnsList(root.left, ansList);
        if (preNode != null) {
            if (preNode.val == root.val) {
                tempCnt++;
            } else {
                tempCnt = 1;
            }
        }
        if (tempCnt > maxCnt) {
            maxCnt = tempCnt;
            ansList.clear();
            ansList.add(root.val);
        } else if (tempCnt == maxCnt) {
            ansList.add(root.val);
        }
        preNode = root;
        getAnsList(root.right, ansList);
    }
}

