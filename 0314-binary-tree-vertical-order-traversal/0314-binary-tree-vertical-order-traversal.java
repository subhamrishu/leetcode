/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class TreePos{
        TreeNode node;
        int level;
        int pos;
        TreePos(TreeNode root, int x, int y){
            node = root;
            level = x;
            pos = y;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        int l = 0, p = 0;
        Queue<TreePos> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        q.offer(new TreePos(root, 0, 0));
        int min = 1000, max = -1000;
        while (!q.isEmpty()){
            int len = q.size();
            
            for (int i = 0; i < len; i++){
                TreePos curr = q.poll();
                if (!map.containsKey(curr.pos))
                    map.put(curr.pos, new ArrayList<>());
                map.get(curr.pos).add(curr.node.val);
                if (curr.node.left != null){
                    q.offer(new TreePos(curr.node.left, curr.level+1, curr.pos-1));
                }
                if (curr.node.right != null){
                    q.offer(new TreePos(curr.node.right, curr.level+1, curr.pos+1));
                }
                min = Math.min(min, curr.pos);
                max = Math.max(max, curr.pos);
            }
        }
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = min; i<=max; i++){
            if (map.containsKey(i)){
                sol.add(map.get(i));
            }
        }
        return sol;
    }
}