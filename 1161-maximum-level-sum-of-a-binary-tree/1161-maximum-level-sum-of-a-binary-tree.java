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
    public int maxLevelSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE, -1};
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()){
            int sum = 0;
            int size = q.size();
            // TreeNode curr = q.poll();
            for (int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            if (max[0] < sum){
                max[0] = sum;
                max[1] = level;
            }
            level++;
        }
        return max[1];
    }
}