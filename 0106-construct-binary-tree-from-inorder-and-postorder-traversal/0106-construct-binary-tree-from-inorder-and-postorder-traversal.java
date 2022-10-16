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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        Map<Integer, Integer> iMap = new HashMap();
        for(int i = 0; i < len; ++i) iMap.put(inorder[i], i);
        
        return constructTree(0, len-1, postorder, 0, iMap);
    }
    private TreeNode constructTree(int postS, int postE, int[] pO, int inRoot, Map<Integer, Integer> iMap){
        if(postS > postE) return null;
        
        TreeNode root = new TreeNode(pO[postE]);
        int index = iMap.get(pO[postE]);
        int count = index - inRoot;
        
        root.left = constructTree(postS, postS+count-1, pO, inRoot, iMap);
        root.right = constructTree(postS+count, postE-1, pO, index+1, iMap);
        return root;
    }
}