/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    boolean searchPath(ListNode head, TreeNode root){
        if (root == null)
            return head == null;
        else if (head == null)
            return true;
        else if(head.val != root.val)
            return false;
        return searchPath(head.next, root.left) || searchPath(head.next, root.right);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        if(head.val == root.val){
            if(searchPath(head, root))
                return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
}