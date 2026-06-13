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
  -15
10   20
   15  5
-5   null

left right root 
post order ()
*/
class Solution {
    private int maxSoFar = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSoFar;
    }
    private  int dfs(TreeNode node){
       if(node == null){
        return 0;
       }
       int left = Math.max(dfs(node.left),0);
       int right = Math.max(dfs(node.right), 0);
       maxSoFar = Math.max(maxSoFar, node.val + left + right);
       return node.val + Math.max(left, right);
    }
}
