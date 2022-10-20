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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        int counter = 0;
        while(node != null){
            if(node.left == null){
                counter++;
                if(counter == k) return node.val;
                node = node.right;
            } else{
                TreeNode prev = node.left;
                while(prev.right != null && prev.right != node) prev = prev.right;
                
                if(prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    counter++;
                    if(counter == k) return node.val;
                    prev.right = null;
                    node = node.right;
                }
            }
        }
        return -1;
    }
}