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
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return makeBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode makeBST(int[] pre, int min, int max){
        if(index >= pre.length) return null;
        
        if(min >= pre[index] || pre[index] >= max) return null;
        
        TreeNode root = new TreeNode(pre[index]);
        index++;
        root.left = makeBST(pre, min, root.val);
        root.right = makeBST(pre, root.val, max);
        
        return root;
    }
}
/*
    
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if(len == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < len; ++i) insert(preorder[i], root);
        return root;
    }
    private void insert(int val, TreeNode root){
        if(root.val > val){
            if(root.left == null) root.left = new TreeNode(val);
            else insert(val, root.left);
        } else{
            if(root.right == null) root.right = new TreeNode(val);
            else insert(val, root.right);
        }
    }
}

*/