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
    public int findBottomLeftValue(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        
        int level = 0, leftmost = root.val;
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()){
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if (flag == false){
                    leftmost = curr.val;
                    flag = true;
                }
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
                
            }
            flag = false;
        }
        return leftmost;
    }
}