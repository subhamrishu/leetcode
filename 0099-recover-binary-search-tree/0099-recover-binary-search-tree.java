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
    TreeNode x = null, y = null, parent = null;
    void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    void helper(TreeNode root){
        if (root == null){
            return;
        }
        helper(root.left);
        if (parent != null && root.val < parent.val){
            y = root;
            if (x == null) x = parent;
            else return;
        }
        parent = root;
        helper(root.right);
    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        
        helper(root);
        swap(x, y);
        
    }
}