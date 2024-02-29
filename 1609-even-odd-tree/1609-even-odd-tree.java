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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0, prev = 0;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            int prevEven = 0, prevOdd = 1000001;
            for (int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                int val = curr.val;
                // if (i == 0){
                //     prev = val;
                // }
                // System.out.println("level = "+level+" curr.val = "+val+" prevEven="+prevEven+" prevOdd= "+prevOdd);
                if (level % 2 == 0){
                    if (prevEven >= val || val % 2 == 0) return false;
                    prevEven = val;
                }else if(level % 2 == 1){
                    if (prevOdd <= val || val % 2 == 1) return false;
                    prevOdd = val;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                
                
            }
            level++;
        }
        return true;
    }
}