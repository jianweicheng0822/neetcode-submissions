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
    Find p and q in bianry seach tree

    root.val > p and q, p and q should be left side of the tree
    root.val < p and q, should right side of the tree

    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        if(root.val > p.val && root.val > q.val){
            TreeNode left  = lowestCommonAncestor(root.left, p, q);
            if(left != null){
                return left;
            }
        }else if(root.val < p.val && root.val < q.val){
            TreeNode right  = lowestCommonAncestor(root.right, p, q);
            if(right != null){
                return right;
            }
        }else{
            return root;
        }
        return root;
    
    }
}
