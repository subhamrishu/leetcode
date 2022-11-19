/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> sol = new ArrayList<>();
        if(root == null)
            return sol;
        q.add(root);
        while (q.size() > 0){
            List<Integer> temp = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++){
                Node curr = q.poll();
                temp.add(curr.val);
                for(Node ch : curr.children){
                    q.add(ch);
                }
            }
            sol.add(temp);
        }
        return sol;
    }
}