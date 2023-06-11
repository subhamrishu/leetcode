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
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node newHead = dummy;
        while (head != null){
            if(map.containsKey(head)){
                newHead.next = map.get(head);
            }else{
                newHead.next = new Node(head.val);
                map.put(head, newHead.next);
            }
            newHead = newHead.next;
            if (map.containsKey(head.next)){
                newHead.next = map.get(head.next);
            }else if (head.next != null){
                newHead.next = new Node(head.next.val);
                map.put(head.next, newHead.next);
            }
            else {
                newHead.next = null;
            }
            if (map.containsKey(head.random)){
                newHead.random = map.get(head.random);
            }else if (head.random != null){
                    newHead.random = new Node(head.random.val);
                    map.put(head.random, newHead.random);
            }
            head = head.next;
        }
            // newHead = newHead.next;
        
        return dummy.next;
    }
}