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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        Map<Integer, Integer> iMap = new HashMap();
        for(int i = 0; i < len; ++i) iMap.put(inorder[i], i);
        
        return constructTree(0, len-1, preorder, 0, iMap);
    }
    private TreeNode constructTree(int preS, int preE, int[] pre, int inRoot, Map<Integer, Integer> iMap){
        if(preS > preE) return null;
        if(preS == preE) return new TreeNode(pre[preS]);
        
        TreeNode root = new TreeNode(pre[preS]);
        int index = iMap.get(pre[preS]);
        int count = index - inRoot;
        root.left = constructTree(preS+1, preS + count, pre, inRoot, iMap);
        root.right = constructTree(preS + count+1, preE, pre, index+1, iMap);
        return root;
    }
}