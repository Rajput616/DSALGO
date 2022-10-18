
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if(len == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < len; ++i) insert(preorder[i], root);
        return root;
    }
    private void insert(int val, TreeNode root){
        if(root.val > val){
            if(root.left == null) root.left = new TreeNode(val);
            else insert(val, root.left);
        } else{
            if(root.right == null) root.right = new TreeNode(val);
            else insert(val, root.right);
        }
    }
}