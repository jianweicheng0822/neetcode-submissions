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
    BFS  - level by level
    DFS  - preorder(root, l , r), inorder(l, root, r), postorder(l r root)
    
    1
   3 2
  7 6 4 5  

  Use pre order  to invert the tree
    */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        // root left mid 
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
