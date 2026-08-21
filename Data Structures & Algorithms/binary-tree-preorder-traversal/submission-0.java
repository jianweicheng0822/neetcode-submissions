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
    private List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        dfs(root);
        return result;
    //pre-order
    //mid left right
    }
    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        result.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}