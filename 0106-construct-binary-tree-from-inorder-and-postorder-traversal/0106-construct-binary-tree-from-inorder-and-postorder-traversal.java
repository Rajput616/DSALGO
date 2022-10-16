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
    int postE;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        postE = len-1;
        Map<Integer, Integer> iMap = new HashMap();
        for(int i = 0; i < len; ++i) iMap.put(inorder[i], i);
        
        return constructTree(0, len-1, postorder, iMap);
    }
    private TreeNode constructTree(int left, int right, int[] pO, Map<Integer, Integer> iMap){
        if(left > right) return null;
        
        TreeNode root = new TreeNode(pO[postE]);
        int index = iMap.get(pO[postE]);
        postE--;
        
        root.right = constructTree(index+1, right, pO, iMap);
        root.left = constructTree(left, index-1, pO, iMap);
        return root;
    }
}