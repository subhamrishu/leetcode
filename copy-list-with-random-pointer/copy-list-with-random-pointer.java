/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
       if (head == null) return null;
        
        if (!map.containsKey(head)){
            map.put(head, new Node(head.val));
        }else{
            return map.get(head);
        }
        Node newHead = map.get(head);
        
        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);
        
        return newHead;
    }
}