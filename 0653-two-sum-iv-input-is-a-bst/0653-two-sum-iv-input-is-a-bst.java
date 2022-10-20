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
class BSTIterator{
    Stack<TreeNode> st;
    boolean isRev;
    public BSTIterator(TreeNode root, boolean isRev){
        st = new Stack();
        this.isRev = isRev;
        push(st, root);
    }
    public int next(){
        TreeNode node = st.pop();
        if(!isRev) push(st, node.right);
        else push(st, node.left);
        return node.val;
    }
    
    public boolean hasNext(){
        return !st.isEmpty();
    }
    private void push(Stack<TreeNode> st, TreeNode root){
        if(root == null) return;
        while(root != null){
            st.push(root);
            if(!isRev) root = root.left;
            else root = root.right;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);
        int i = left.next(), j = right.next();
        while(i < j){
            if(i + j == k) return true;
            else if(i + j > k) j = right.next();
            else i = left.next();
        }
        return false;
    }
}