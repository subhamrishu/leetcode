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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList();
        if (root == null)
            return view;
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        q.offer(null);
        TreeNode prev=root;
        while (q.size()!=0){
            if (q.peek() == null && q.size()==1){
                view.add(prev.val);
                break;
            }
            TreeNode t = q.poll();
            if(t == null){
                view.add(prev.val);
                q.offer(null);
                continue;
            }
            if (t.left != null)
                q.offer(t.left);
            if(t.right!=null)
                q.offer(t.right);
            prev = t;
        }
        return view;
    }
}