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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int order = 0; //0 -> normal, 1->reverse
        
        Deque<TreeNode> q = new LinkedList<>();
        
        List<List<Integer>> sol = new ArrayList<>();
        if (root == null) return sol;
        
        q.add(root);
        while (!q.isEmpty()){
            
            List<Integer> temp = new ArrayList<>();
            
            for (int i = q.size(); i > 0; i--){
                
                TreeNode curr = q.poll();
                if (curr.left != null){
                        q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                if (order == 0){ 
                    temp.add(curr.val);
                }else{
                    temp.addFirst(curr.val);
                }
            }
            order ^= 1;
            sol.add(temp);
        }
        return sol;
    }
}