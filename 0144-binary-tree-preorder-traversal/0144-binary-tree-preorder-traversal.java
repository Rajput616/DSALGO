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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null) return list;
        Stack<TreeNode> st = new Stack();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            list.add(node.val);
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left); 
        }
        return list;
    }
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList();
    //     TreeNode curr = root;
    //     while(curr != null){
    //         if(curr.left == null){
    //             list.add(curr.val);
    //             curr = curr.right;
    //         } else{
    //             TreeNode prev = curr.left;
    //             while(prev.right != null && prev.right != curr) prev = prev.right;
    //             if(prev.right == null){
    //                 prev.right = curr;
    //                 list.add(curr.val);
    //                 curr = curr.left;
    //             } else{
    //                 prev.right = null;
    //                 curr = curr.right;
    //             }
    //         }
    //     }
    //     return list;
    // }
}
// Root, left, right;
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList();
//         preOrder(root, list);
//         return list;
//     }
//     private void preOrder(TreeNode root, List<Integer> list){
//         if(root == null) return;
//         list.add(root.val);
//         preOrder(root.left, list);
//         preOrder(root.right, list);
//     }
// }

