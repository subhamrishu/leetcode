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
    class SubTree{
        double avg;
        int num;
        SubTree(double avg, int num){
            this.avg = avg;
            this.num = num;
        }
    }
    double max = 0.0;
    SubTree helper(TreeNode root){
        if (root == null){
            return new SubTree(0.0, 0);
        }
        SubTree left = helper(root.left);
        SubTree right = helper(root.right);
        int num = left.num + right.num + 1;
        
        double avg = (left.avg * left.num + right.avg * right.num + root.val) / num * 1.0;
        // System.out.println("root = "+ root.+ " left.avg = "+ left.avg + " right.avg = " + right.avg + " left.num = "+ left.num + " right.num = "+right.num+" num = "+num);
        max = Math.max(max, avg);
        return new SubTree(avg, num);
    }
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;
    }
}