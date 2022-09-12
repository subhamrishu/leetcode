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
    ListNode getMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            if (fast.next != null && fast.next.next != null)
                fast = fast.next.next;
            else
                break;
        }
        return slow;
    }
    ListNode reverseList(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    public void reorderList(ListNode head) {
        // System.out.println(getMiddle(head).val);
        ListNode middle = getMiddle(head);
        ListNode firstHalf = head;
        ListNode secondHalf = middle.next;
        middle.next = null;
        secondHalf = reverseList(secondHalf);
        
        ListNode dummy = new ListNode();
        ListNode itr = dummy;
        while (firstHalf!=null || secondHalf!=null){
            if (firstHalf != null){
                itr.next = firstHalf;
                firstHalf = firstHalf.next;
                itr = itr.next;
            }
            if (secondHalf != null){
                itr.next = secondHalf;
                secondHalf = secondHalf.next;
                itr = itr.next;
            }
        }
        itr.next = null;
        // return dummy.next;
    }
}