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
        ListNode dummy = new ListNode(0, null);
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            l1.val = sum%10;
            carry = sum/10;
            head.next = l1;
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        while (l1 != null){
            int sum = l1.val + carry;
            l1.val = sum%10;
            carry = sum/10;
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null){
            int sum = l2.val + carry;
            l2.val = sum%10;
            carry = sum/10;
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        if (carry != 0){
            head.next = new ListNode(carry, null);
        }
        return dummy.next;
    }
}