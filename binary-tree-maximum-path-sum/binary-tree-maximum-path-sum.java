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
    int max = Integer.MIN_VALUE;
    int helper(TreeNode root){
        if (root == null) return 0;
        
        int leftPathSum = Math.max(helper(root.left), 0);
        int rightPathSum = Math.max(helper(root.right), 0);
        
        max = Math.max(max, root.val + leftPathSum + rightPathSum);
        return root.val + Math.max(leftPathSum, rightPathSum);
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
}