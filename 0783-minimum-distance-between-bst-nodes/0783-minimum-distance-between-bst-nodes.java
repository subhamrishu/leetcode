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
    ArrayList<Integer> l = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        helper(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l.size()-1; i++){
            min = Math.min(min, l.get(i+1) - l.get(i));
        }
        return min;
    }
    void helper(TreeNode root){
        if (root == null)
            return;
        
        helper(root.left);
        l.add(root.val);
        helper(root.right);
    }
}