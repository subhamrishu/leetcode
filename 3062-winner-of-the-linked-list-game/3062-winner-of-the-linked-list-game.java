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
    public String gameResult(ListNode head) {
        int odd = 0, even = 0;
        
        while(head != null){
            if (head.val > head.next.val)
                even++;
            else if (head.val < head.next.val)
                odd++;
            
            head = head.next.next;
        }
        return even == odd ? "Tie" : (even > odd) ? "Even" : "Odd";
    }
}