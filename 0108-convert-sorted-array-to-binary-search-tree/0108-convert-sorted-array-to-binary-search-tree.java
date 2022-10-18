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
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(0, nums.length-1, nums);
    }
    
    private TreeNode makeBST(int i, int j, int[] nums){
        if(i > j) return null;
        
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(i, mid-1, nums);
        root.right = makeBST(mid+1, j, nums);
        return root;
    }
}