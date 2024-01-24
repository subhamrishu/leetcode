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
    boolean checkPalindrome(int[] freq){
        int odd = 0;
        for (int i = 1; i<=9; i++){
            if (freq[i] % 2 == 1)
                odd++;
        }
        return odd < 2;
    }
    int helper(TreeNode root, int[] freq){
        if (root == null)
            return 0;
        freq[root.val]++;
        if (root.left == null && root.right == null)
            return checkPalindrome(freq) == true ? 1 : 0;
        
        int l = helper(root.left, freq);
        if (root.left != null)
            freq[root.left.val]--;
        int r = helper(root.right, freq);
        if (root.right != null)
            freq[root.right.val]--;
        
        return l+r;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        return helper(root, freq);
        
    }
}