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
    Integer maxD;
    public int diameterOfBinaryTree(TreeNode root) {
        maxD = 0;
        travel(root);
        return maxD;    
    }
    private int travel(TreeNode root){
        if(root == null) return 0;
        
        int leftPath = travel(root.left);
        int rightPath = travel(root.right);
        
        maxD = Math.max(maxD, leftPath + rightPath);
        
        return 1 + Math.max(leftPath, rightPath);
    }
}