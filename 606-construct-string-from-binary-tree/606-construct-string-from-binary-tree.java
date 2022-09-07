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
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        String LeftString = tree2str(root.left);
        String RightString = tree2str(root.right);
        if(LeftString.length() == 0 && RightString.length() == 0) return String.valueOf(root.val);
        else if(RightString.length() == 0) return root.val + "(" + LeftString + ")";
        else if(LeftString.length() == 0) return root.val + "()" + "(" + RightString + ")";
        return root.val + "(" + LeftString + ")(" +RightString + ")";
    }
}