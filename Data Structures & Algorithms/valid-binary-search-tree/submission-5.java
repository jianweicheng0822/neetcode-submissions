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
    /*
    In BST, use dfs with in-order to find a increasing order.
 prev cur 
 
    2 1 3 
    p c
    c > prev && prev != null
    return false;
    */
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
         //left root right
         boolean left = isValidBST(root.left);
         if(prev != null && prev.val >= root.val){
            return false;
         }
         prev = root;
         boolean right = isValidBST(root.right);
         return left && right;
    }
}
