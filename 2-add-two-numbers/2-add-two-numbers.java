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
        ListNode head  = dummy;
        //i'll use list1 for the final answer
        while (l1 != null || l2 != null){
            // int a = 0, b = 0;
            int a = (l1 == null) ? 0 : l1.val;
            int b = (l2 == null) ? 0 : l2.val;
            
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            if (l1 != null){
                l1.val = sum;
                head.next = l1;
            }
            else if (l2 != null){
                l2.val = sum;
                head.next = l2;
            }
            head = head.next;
            
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if (carry != 0){
            head.next = new ListNode(carry);
            head = head.next;
        }
        head.next = null;
        return dummy.next;
    }
}