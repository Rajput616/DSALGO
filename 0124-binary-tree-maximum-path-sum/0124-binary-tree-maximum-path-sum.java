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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        getSum(root);
        return maxSum;
    }
    private int getSum(TreeNode root){
        if(root == null) return 0;
        
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int sum = Math.max(leftSum, rightSum);
        
        maxSum = Math.max(maxSum, Math.max(root.val, Math.max(root.val + sum, leftSum + rightSum + root.val)));
        return Math.max(root.val, sum + root.val);
    }
    
}