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
    public void flatten(TreeNode root) {
        /*
        while (root!=null){
            TreeNode curr = root;
            if (curr.left != null){                
                TreeNode rightmost = root.left;
                while(rightmost.right!=null)
                    rightmost = rightmost.right;
                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            root = root.right;
        }
        */
        if(root == null || (root.left == null && root.right == null))
            return;
        if (root.left != null){
            flatten(root.left);
            
            TreeNode temp= root.right;
            root.right = root.left;
            root.left = null;
            
            TreeNode rightmost = root.right;
            while (rightmost.right!=null)
                rightmost = rightmost.right;
            
            rightmost.right = temp;
        }
        flatten(root.right);
    }
}