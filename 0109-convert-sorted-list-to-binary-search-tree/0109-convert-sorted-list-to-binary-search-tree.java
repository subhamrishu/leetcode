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
    ListNode findMiddle(ListNode head){
        if (head == null || head.next== null) return head;
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
        }
        return slow;
    }
    TreeNode helper(ListNode head){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return new TreeNode(head.val, null, null);
        }
        ListNode midPrev = findMiddle(head);
        int val = midPrev.next.val;
        ListNode midNext = midPrev.next.next;
        midPrev.next.next = null;
        midPrev.next = null;
        // System.out.println(mid.val);
        
        
        // mid.next = null;
        TreeNode temp = new TreeNode(val);
        temp.left = helper(head);
        temp.right = helper(midNext);
        return temp;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }
}