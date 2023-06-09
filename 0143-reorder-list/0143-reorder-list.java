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
    private ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode curr = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        //find middle
        ListNode slow = head, fast = head, prev = head;
        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half
        ListNode middle=reverseList(slow);
        prev.next = null;
        
        //merge the lists;
        ListNode next= head;
        while (head != null  && next!= null && middle != null){
            next = head.next;
            head.next = middle;
            middle = middle.next;
            head = head.next;
            if (next != null){
                head.next = next;
                head = head.next;
            }
        }
    }
}