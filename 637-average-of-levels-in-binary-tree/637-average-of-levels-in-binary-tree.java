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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sol = new ArrayList();
        if (root == null)
            return sol;
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int n = q.size();
            double avg = 0.0;
            for (int i = 0; i < n; i++){
                TreeNode curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right!=null)  q.offer(curr.right);
                avg += curr.val;
            }
            sol.add((double)avg/n);
        }
        return sol;
    }
}