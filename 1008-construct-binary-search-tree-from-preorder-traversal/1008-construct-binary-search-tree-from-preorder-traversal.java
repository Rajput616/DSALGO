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
    public TreeNode bstFromPreorder(int[] preorder) {
        return makeBST(0, preorder.length-1, preorder);
    }
    private TreeNode makeBST(int i, int j, int[] preorder){
        if(i > j) return null;
        
        TreeNode root = new TreeNode(preorder[i]);
        int count = 0;
        for(int k = i+1; k <= j; ++k){
            if(preorder[k] > preorder[i]){
                break;
            }
            count++;
        }
        
        root.left = makeBST(i+1, i+count, preorder);
        root.right = makeBST(i+count+1, j, preorder);
        return root;
    }
}