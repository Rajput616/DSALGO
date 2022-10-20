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
    int max;
    public int maxSumBST(TreeNode root) {
        max = 0;
        findSum(root);
        return max;
    }
    private int[] findSum(TreeNode root){
        if(root == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        int[] left = findSum(root.left);
        int[] right = findSum(root.right);
        int sum = 0;
        if(root.val > left[2] && root.val < right[1]){
            sum = root.val + left[0] + right[0];
            max = Math.max(max, sum);
            return new int[]{sum, Math.min(root.val, left[1]), Math.max(root.val, right[2])};
        }
        
        return new int[]{sum, Integer.MIN_VALUE, Integer.MAX_VALUE};
    }
}