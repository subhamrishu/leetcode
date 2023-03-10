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
    int size;
    List<Integer> list;
    Random rand = new Random();
    public Solution(ListNode head) {
        list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        size = list.size();
    }
    
    public int getRandom() {
        int randomNum = rand.nextInt(size);
        return list.get(randomNum);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */