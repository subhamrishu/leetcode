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
        if(l1 == null || l2 == null) 
            return l1 != null ? l1 : l2;
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
    ListNode mergeKListsHelper(ListNode[] lists, int left, int right) {
        if(left > right) 
            return null;
        
        if(left == right) 
            return lists[left];
        
        int mid = (left + right) / 2;
        ListNode l1 = mergeKListsHelper(lists, left, mid);
        ListNode l2 = mergeKListsHelper(lists, mid + 1, right);
        
        return mergeTwoLists(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeKListsHelper(lists, 0, lists.length-1);
    }
}