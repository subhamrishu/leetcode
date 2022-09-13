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
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node headCopy = head;
        map.put(null, null);
        while (headCopy != null){
            map.put(headCopy, new Node(headCopy.val));
            headCopy = headCopy.next;
        }
        headCopy = head;
        
        while (headCopy != null){
            map.get(headCopy).next = map.get(headCopy.next);
            map.get(headCopy).random = map.get(headCopy.random);
            headCopy = headCopy.next;
        }
        return map.get(head);
    }
}