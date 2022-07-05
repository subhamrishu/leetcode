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
        List<List<Integer>> sol = new ArrayList();
        if (root == null)
            return sol;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        q.offer(null);
        List<Integer> temp = new ArrayList();
        while (!q.isEmpty()){
            // if (q.size() == 1 && q.peek() == null)
            //     break;
            TreeNode curr = q.poll();
            if (curr == null){
                sol.add(temp);
                temp = new ArrayList();
                if (q.size() > 0)
                    q.add(null);
                continue;
            }
            temp.add(curr.val);
            if(curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return sol;
    }
}