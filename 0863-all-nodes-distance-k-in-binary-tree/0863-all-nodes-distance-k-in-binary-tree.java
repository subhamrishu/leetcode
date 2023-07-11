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
    void dfs(TreeNode root, int k, int dist, Map<TreeNode, Integer> map, List<Integer> sol){
        if (root == null)
            return;
        if (map.containsKey(root))
            dist = map.get(root);
        if (dist == k)
            sol.add(root.val);
        dfs(root.left, k, dist+1, map, sol);
        dfs(root.right, k, dist+1, map, sol);
    }
    int findTarget(TreeNode root, TreeNode target, Map<TreeNode, Integer> map){
        if (root == null)
            return -1;
        else if (root == target){
            map.put(root, 0);
            return 0;
        }
        int left = findTarget(root.left, target, map);
        if (left >= 0){
            map.put(root, left + 1);
            return left+1;
        }
        int right = findTarget(root.right, target, map);
        if (right >= 0){
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Integer> map = new HashMap<>();
        List<Integer> sol = new LinkedList<>();
        findTarget(root, target, map);
        dfs(root, k, map.get(root), map, sol);
        return sol;
    }
    
}