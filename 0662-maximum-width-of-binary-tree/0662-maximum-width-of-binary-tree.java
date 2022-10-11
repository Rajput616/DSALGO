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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair<Integer, TreeNode>> q = new LinkedList();
        q.offer(new Pair(0, root));
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int first = 0, last = 0;
            for(int i = 0; i < size; ++i){
                Pair<Integer,TreeNode> p = q.poll();
                int up_key = p.getKey();
                if(i == 0) first = up_key;
                if(i == size-1) last = up_key;
                TreeNode node = p.getValue();
                if(node.left != null) q.offer(new Pair(up_key*2 + 1, node.left));
                if(node.right != null) q.offer(new Pair(up_key*2 + 2, node.right));
            }
            ans = Math.max(ans, last - first+1);
        }
        return ans;
    }
}