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
    int count = 0;
    void goodNodes(TreeNode root, int curr){
        if (root == null)
            return;
        if (root.val >= curr){
            count++;
        }
        goodNodes(root.left, Math.max(curr, root.val));
        goodNodes(root.right, Math.max(curr, root.val));
    }
    public int goodNodes(TreeNode root) {
        goodNodes(root, Integer.MIN_VALUE);
        return count;
    }
}