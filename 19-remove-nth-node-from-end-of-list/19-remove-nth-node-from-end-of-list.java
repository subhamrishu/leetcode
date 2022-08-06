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
    int pos;
    void helper(ListNode head){
        if (head == null){
            return;
        }
        helper(head.next);
        pos--;
        if (pos == 0){
            head.next = head.next.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        pos = n+1;
        helper(head);
        return pos == 1 ? head.next: head;
    }
}