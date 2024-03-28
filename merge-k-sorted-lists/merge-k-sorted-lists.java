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
    ListNode merge(ListNode left, ListNode right){
        if (left == null) return right;
        if(right == null) return left;

        if (left.val <= right.val){
            left.next = merge(left.next, right);
            return left;
        }else{
            right.next = merge(left, right.next);
            return right;
        }
    }
    ListNode divide(ListNode[] lists, int start, int end){
        if (start == end) return lists[start];

        if (start < end){
            int mid = start + (end - start)/2;
            ListNode left = divide(lists, start, mid);
            ListNode right = divide(lists, mid+1, end);
            return merge(left, right);
        }
        return null;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length-1);
    }
}