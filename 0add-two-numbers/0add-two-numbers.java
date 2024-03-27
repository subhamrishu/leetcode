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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;
        
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            newHead.next = new ListNode(sum%10);
            newHead = newHead.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int sum = l1.val + carry;
            newHead.next = new ListNode(sum%10);
            newHead = newHead.next;
            carry = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null){
            int sum = l2.val + carry;
            newHead.next = new ListNode(sum%10);
            newHead = newHead.next;
            carry = sum / 10;
            l2 = l2.next;
        }
        
        if (carry != 0){
            newHead.next = new ListNode(carry);
            newHead = newHead.next;
        }
        newHead.next = null;
        return dummy.next;
    }
}