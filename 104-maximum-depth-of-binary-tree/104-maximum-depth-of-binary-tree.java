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
    int max = 0;
    void helper(TreeNode root, int count){
        if (root == null)
            return;
        helper(root.left, count + 1);
        helper(root.right, count + 1);
        max = Math.max(count, max);
    }
    public int maxDepth(TreeNode root) {
        
        helper(root, 0);
        return root == null ? max : max +1;
        
    }
}