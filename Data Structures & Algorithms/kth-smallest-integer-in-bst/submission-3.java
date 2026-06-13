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
    private int count = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        count = k;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);//left
        count--;
        if(count == 0){
            res = node.val;
        }
        dfs(node.right);
        
    }
}
