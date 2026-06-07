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
1 
 2 


*/
class Solution {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       dfs(root);
       return diameter;
    }
    private int dfs(TreeNode node){
        //post order
        //Base condition
        if(node == null){
            return 0;
        }
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight,rightHeight);
    }
}
