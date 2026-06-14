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
/*
dfs pre order
root left mid

*/
public class Codec {
    private StringBuilder sb;
    private int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        dfs(root);
        return sb.toString();
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        dfs(node.left);
        dfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        return dfss(parts);
    }
    private TreeNode dfss(String[] parts) {
        if (index >= parts.length) {
            return null;
        }
        if (parts[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(parts[index]));
        index++;
        cur.left = dfss(parts);
        cur.right = dfss(parts);
        return cur;
    }
}
