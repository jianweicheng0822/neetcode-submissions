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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(isSameTree(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSameTree(TreeNode node, TreeNode subRoot){
        if(node == null && subRoot == null){
            return true;
        }
        if(node != null && subRoot != null && node.val == subRoot.val){
            return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
        }
        return false;
    }
}
