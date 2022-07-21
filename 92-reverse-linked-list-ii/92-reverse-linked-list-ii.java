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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        if (head == null || head.next == null)
            return head;
        if(left == right)
            return head;
        ListNode head1 = head, old=head;
        while (count != left){
            old = head;
            head = head.next;
            count++;
        }
        
        // System.out.printf("head=%d, old=%d \n", head.val, old.val);
        ListNode prev=head, curr=head, next=head.next;
        while(count != right){
            prev = curr;
            curr = next;
            next = curr.next;
            curr.next = prev;
            count++;
            // System.out.printf("prev=%d, curr=%d, next=%d (Inside)\n", prev.val, curr.val, next.val);
        }
        // System.out.printf("prev=%d, curr=%d, next=%d", prev.val, curr.val, next.val);
        if(old.next.next == old){
            old.next = next;
            return curr;
        }
        else{
            old.next.next = next;
            old.next = curr;
        }
        return head1;
    }
}