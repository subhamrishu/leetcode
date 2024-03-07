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
        if (head == null || head.next == null)
            return head;
        
        ListNode l = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        // l.next = head;
        return l;
        
        
    }
    ListNode findMiddleNode(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public int pairSum(ListNode head) {
        ListNode middle = findMiddleNode(head);
        ListNode reversed = reverseList(middle);
        // ListNode temp = reversed;
        // while (temp!=null){
        //     System.out.println(temp.val);
        //     temp = temp.next;
        // }
        int sum = 0, max = 0;
        ListNode left = head, right = reversed;
        while (left != null && right != null){
            
            sum = left.val + right.val;
            max = Math.max(max, sum);
            // System.out.println("left.val="+left.val+" right.val="+right.val+" max="+max+" sum ="+sum);
            left = left.next;
            right = right.next;
        }
        return max;
    }
}