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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxD = new int[1];
        travel(root, maxD);
        return maxD[0];    
    }
    private int travel(TreeNode root, int[] maxD){
        if(root == null) return 0;
        
        int leftPath = travel(root.left, maxD);
        int rightPath = travel(root.right, maxD);
        
        maxD[0] = Math.max(maxD[0], leftPath + rightPath);
        
        return 1 + Math.max(leftPath, rightPath);
    }
}