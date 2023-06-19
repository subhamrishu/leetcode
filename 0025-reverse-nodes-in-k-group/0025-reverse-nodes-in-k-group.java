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
    public void reverse(ListNode curr, ListNode end){
        if (curr == end)
            return;
        reverse(curr.next, end);
        curr.next.next = curr;
        curr.next = null;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode dummy = new ListNode();

        ListNode slow = head, fast = head, temp = dummy;
        int k1 = k-1;
        
        while (fast != null){
            while (fast != null && k1 > 0){
                fast = fast.next;
                k1--;
            }
            if (fast != null){
                ListNode next = fast.next;
                reverse(slow, fast);
                temp.next = fast;
                temp = slow;
                slow = next;
                fast = next;
            }
            k1 = k-1;
        }
        temp.next = slow;
        return dummy.next;
    }
}