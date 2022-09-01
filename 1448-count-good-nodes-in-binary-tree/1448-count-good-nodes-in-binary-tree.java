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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        checkGoodNodes(root, Integer.MIN_VALUE);
        return count;
    }
    private void checkGoodNodes(TreeNode node, int prev){
        if(node == null) return;
        if(node.val >= prev) count++;
        prev = Math.max(prev, node.val);
        
        checkGoodNodes(node.left, prev);
        checkGoodNodes(node.right, prev);
    }
}