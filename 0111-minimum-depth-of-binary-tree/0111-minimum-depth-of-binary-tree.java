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
    int helper(TreeNode root){
        if (root == null)
            return Integer.MAX_VALUE -1;
        else if (root.left == null && root.right == null)
            return 1;
        int left = 1 + helper(root.left);
        int right = 1 + helper(root.right);
        return Math.min(left, right);
    }

    public int minDepth(TreeNode root) {
       if (root == null)
           return 0;
        return helper(root);
    }
}