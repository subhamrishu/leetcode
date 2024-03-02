/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node prev = null;
    public Node flatten(Node head){
        if (head == null)
            return head;
        Node nextNode = head.next;
        
        head.prev = prev;
        prev = head;
        
        head.next = flatten(head.child);
        head.child = null;
        
        prev.next = flatten(nextNode);
        
        return head;
    }
}