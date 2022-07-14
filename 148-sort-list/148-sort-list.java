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
    // String printNode(ListNode temp){
    //     if (temp == null)
    //         return "null";
    //     return Integer.toString(temp.val);
    // }
    ListNode mergeLists(ListNode head1, ListNode head2){
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
      
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (head1!=null && head2!=null){
            if (head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next; 
        }
        while (head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    ListNode findMiddleNode(ListNode head){
        if (head == null)
            return null;
       
        ListNode slow = head, fast =head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    ListNode mergeSort(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMiddleNode(head);
        ListNode next_head = mid.next;
        mid.next = null;
        
        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(next_head);
        ListNode root = mergeLists(head1, head2);

        return root;
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}