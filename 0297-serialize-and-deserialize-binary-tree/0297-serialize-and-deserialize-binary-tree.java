/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    void buildString(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(",null");
            return;
        }
        sb.append(","+root.val);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    TreeNode buildTree(Deque<String> q){
        String curr = q.poll();
        if (curr.equals("null")){
            return null;
        }
        TreeNode t = new TreeNode(Integer.valueOf(curr));
        t.left = buildTree(q);
        t.right = buildTree(q);
        return t;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new LinkedList<>();
        String[] tokens = data.split(",");
        for (int i = 1; i < tokens.length; i++){
            q.offer(tokens[i]);
        }
        System.out.println(q);
        return buildTree(q);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));