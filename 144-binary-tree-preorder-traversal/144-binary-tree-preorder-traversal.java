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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        
        if (root == null )
            return sol;
        stack.add(root);
        while (stack.size() != 0){
            TreeNode curr = stack.pop();
            sol.add(curr.val);
            if (curr.right!=null)
                stack.add(curr.right);
            if (curr.left != null)
                stack.add(curr.left);
            
        }
        return sol;
    }
}