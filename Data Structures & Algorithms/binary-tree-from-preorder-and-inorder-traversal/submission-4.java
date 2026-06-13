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
    
   preorder = [3, 9, 20, 15, 7]
                      pl     pr
                 pl  +  index - il 
   inorder  = [2, 9, 3, 15, 20, 7]
               il      index + 1,       ir
  we find 3 is root
  so [9] is left subtree,  [15 20 7] is rightsubtree

    
    */
    private Map<Integer, Integer> m = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Edge case
        if(preorder == null || inorder == null || preorder.length ==0 || inorder.length ==0){
            return null;
        }
        for(int i =0; i < inorder.length; i++){
            m.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if(pl > pr || il > ir){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int index = m.get(root.val);
        int leftSize = index - il;
        root.left = build(preorder, inorder, pl + 1, pl + leftSize, il, index -1);
        root.right = build(preorder, inorder, pl+leftSize+1, pr, index+1, ir);
        return root;
        
    }
}
