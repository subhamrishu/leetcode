/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode t = null;
        while (!q.isEmpty()){
            TreeNode curr = q.poll();
            if (curr == target){
                t = curr;
            }
            if (curr.left != null){
                map.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null){
                map.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        q = new LinkedList<>();
        q.add(t);
        List<Integer> sol = new ArrayList<>();
        int level = 0;
        Set<TreeNode> set = new HashSet<>();
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = size; i>0; i--){
                TreeNode curr = q.poll();
                if (set.contains(curr)) continue;
                set.add(curr);
                // System.out.println(curr.val+" "+level);
                if (level == k){
                    sol.add(curr.val);
                }
                if (level > k) break;
                if (curr.left != null){
                    q.add(curr.left);
                }
                if (curr.right != null){
                    q.add(curr.right);
                }
                if (map.containsKey(curr)){
                    q.add(map.get(curr));
                }
            }
            level++;
            // System.out.println(q);
        }
        return sol;
    }
}