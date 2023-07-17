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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        // head.next = null;
        while (!s1.empty() || !s2.empty()){
            int sum  = (s1.empty() ? 0 : s1.pop()) + (s2.empty() ? 0 : s2.pop()) + carry;
            ListNode temp = new ListNode(sum%10);
            temp.next = head;
            head = temp;
            carry = sum/10;
            
        }
        if (carry != 0){
            ListNode temp = new ListNode(carry);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}