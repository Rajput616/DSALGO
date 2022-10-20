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

class Node{
    int min, max, sum;
    
    TreeNode node;
    Node(int min, int max, int sum){
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}

class Solution {
    int maxSum;
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        findSum(root);
        return maxSum;
    }
    private Node findSum(TreeNode root){
        if(root == null) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        Node left = findSum(root.left);
        Node right = findSum(root.right);
        
        int sum = 0;
        if(root.val > left.max && root.val < right.min){
            sum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, sum);
            return new Node(Math.min(root.val, left.min), Math.max(root.val, right.max), sum);
        }
        
        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, sum);
    }
}















