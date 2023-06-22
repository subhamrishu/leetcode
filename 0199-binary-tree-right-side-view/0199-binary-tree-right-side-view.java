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
    public void helper(TreeNode root, int level, List<Integer> sol){
        if (root == null)
            return;
        if (level == sol.size())
            sol.add(root.val);
        helper(root.right, level+1, sol);
        helper(root.left, level+1, sol);
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        helper(root, 0, sol);
        return sol;
    }
}