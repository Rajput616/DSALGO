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
    int maxD;
    public int maxDepth(TreeNode root) {
        maxD = 0;
        travel(root, 0);
        return maxD;
    }
    private void travel(TreeNode root, int depth){
        if(root == null) {
            maxD = Math.max(maxD, depth);
            return;
        }
        
        travel(root.left, depth+1);
        travel(root.right, depth+1);
    }
}