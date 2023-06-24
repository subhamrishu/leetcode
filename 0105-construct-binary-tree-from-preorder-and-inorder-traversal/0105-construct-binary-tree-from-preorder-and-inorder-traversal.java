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
    public TreeNode build(int[] pre, Map<Integer, Integer> map, int p, int iLeft, int iRight){
        if (p >= pre.length)
            return null;
        TreeNode root = new TreeNode(pre[p]);
        int iMid = map.get(root.val);
        if(iLeft < iMid)
            root.left = build(pre, map, p+1, iLeft, iMid-1);
        if(iMid < iRight)
            root.right = build(pre, map, p+iMid-iLeft+1, iMid+1, iRight);
    
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, map, 0, 0, inorder.length);
    }
}