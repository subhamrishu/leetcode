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
    int preOrderInd = 0;
    TreeNode helper(int[] preorder, int[] inorder, Map<Integer, Integer> map, int start, int end){
        if (start > end)
            return null;
        int rootVal = preorder[preOrderInd++];
        TreeNode root = new TreeNode(rootVal);
        int inorderInd = map.get(rootVal);
        
        root.left = helper(preorder, inorder, map, start, inorderInd-1);
        root.right = helper(preorder, inorder, map, inorderInd+1, end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, map, 0, inorder.length-1);
    }
}