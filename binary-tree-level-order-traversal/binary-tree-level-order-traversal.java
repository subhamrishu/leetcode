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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> sol = new ArrayList<>();
        if (root == null) return sol;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
           
            List<Integer> temp = new ArrayList<>();
            
            for (int i = q.size(); i > 0; i--){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr.left != null){
                    q.add(curr.left);   
                }
                if (curr.right != null){
                    q.add(curr.right);
                }
            }
            sol.add(temp);
        }
        return sol;
    }
}