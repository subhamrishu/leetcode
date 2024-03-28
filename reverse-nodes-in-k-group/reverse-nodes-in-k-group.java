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
    ListNode reverseList(ListNode head){
        if (head == null || head.next == null) return head;
        
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null, slow = head, fast = head, oldHead = null, mainHead = null;
        
        while (fast != null){
            int K = k;
            while (K != 0 && fast != null){
                prev = fast;
                fast = fast.next;
                K--;
            }
            if (K != 0) break;
            
            prev.next = null;
            ListNode temp = reverseList(slow);
            if (mainHead == null) mainHead = temp;
            if (oldHead != null){
                oldHead.next = prev;
            }
            oldHead = slow;
            slow.next = fast;
            slow = fast;
        }
        return mainHead;
    }
}