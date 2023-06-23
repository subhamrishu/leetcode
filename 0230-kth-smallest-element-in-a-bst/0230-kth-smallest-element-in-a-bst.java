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
    int sol = -1, l;
    void helper(TreeNode root){
        if (root == null)
            return;
        helper(root.left);
        l--;
        if (l == 0){
            sol = root.val;
            return;
        }
        helper(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        l = k;
        helper(root);
        return sol;
    }
}