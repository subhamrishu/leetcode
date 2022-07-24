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
    ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (l1!=null && l2!=null){
            if (l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            }
            else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null){
            head.next = l1;
        }
        if (l2 != null){
            head.next = l2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head = null;
        for(int i = 0; i < lists.length; i++){
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
}