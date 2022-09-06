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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        boolean isOneThere = prune(root);
        return isOneThere ? root : null;
    }
    private boolean prune(TreeNode root){
        if(root == null) return false;
        
        boolean isOneThereLeft = prune(root.left);
        boolean isOneThereRight = prune(root.right);
        if(!isOneThereLeft){
            root.left = null;
        }
        
        if(!isOneThereRight){
            root.right = null;
        }
        if(root.left == null && root.right == null && root.val != 1) return false;
        return true;
    }
}