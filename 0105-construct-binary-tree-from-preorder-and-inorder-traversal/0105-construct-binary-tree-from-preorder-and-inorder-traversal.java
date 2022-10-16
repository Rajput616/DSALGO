
class Solution {
    int preS;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        Map<Integer, Integer> iMap = new HashMap();
        for(int i = 0; i < len; ++i) iMap.put(inorder[i], i);
        preS = 0;
        return constructTree(0, len-1, preorder, iMap);
    }
    private TreeNode constructTree(int left, int right, int[] pre, Map<Integer, Integer> iMap){
        if(left > right) return null;
        
        TreeNode root = new TreeNode(pre[preS]);
        int index = iMap.get(pre[preS]);
        preS++;
        root.left = constructTree(left, index-1, pre, iMap);
        root.right = constructTree(index+1, right, pre, iMap);
        return root;
    }
}