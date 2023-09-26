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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head==null)
            return head;
        
        if (head.next == null) return null;
        ListNode slow=head, fast=head, prev=head;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            if (fast != null && fast.next != null){
                fast = fast.next.next;
            }
            
        }
        // System.out.println(prev.val);
        prev.next = prev.next.next;
        return head;
        
    }
}