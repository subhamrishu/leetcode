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
    Node flat;
    void printList(Node list){
        while (list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }
    void dfs(Node head){
        if (head == null)
            return;
        Node newNode = new Node();
        newNode.val = head.val;
        newNode.prev = flat;
        newNode.child = null;
        flat.next = newNode;
        // flat.next = head;
        // head.prev = flat;
        flat = flat.next;
        
        // System.out.println("head val"+head.val);
        // printList(flat);
        if(head.child != null)
            dfs(head.child);
        // head.child = null;
        
        dfs(head.next);
    }
    public Node flatten(Node head) {
        Node dummy = new Node();
        flat = dummy;
        dfs(head);
        Node h = dummy.next;
        if (h == null)
            return h;
        h.prev = null;
        h.child = null;
        return h;
    }
}