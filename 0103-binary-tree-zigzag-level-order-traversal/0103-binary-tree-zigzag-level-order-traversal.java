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
        int order = 0; //0 left to right, 1 right to left
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> sol = new ArrayList<>();
        if (root == null)
            return sol;
        q.add(root);
        while (q.size() != 0){
            // TreeNode curr = q.poll();
            int curr_q_size = q.size();
            List<Integer> currNodes = new ArrayList<>();
            for (int i = 0; i < curr_q_size; i++){
                TreeNode curr = q.poll();
                currNodes.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
                // if (order == 1){
                //     if (curr.left != null)
                //         q.add(curr.left);
                //     if (curr.right != null)
                //         q.add(curr.right);
                //     // order = 1;
                // }
                // else{
                //     if (curr.right != null)
                //         q.add(curr.right);
                //     if (curr.left != null)
                //         q.add(curr.left);
                //     // order = 0;
                // }
                
            }
            if (order == 1){
                Collections.reverse(currNodes);
                sol.add(currNodes);
            }
            else
                sol.add(currNodes);
            order = order ^ 1;
            
        }
        return sol;
    }
}