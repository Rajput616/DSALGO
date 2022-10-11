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

class Pair{
    int y, x;
    TreeNode node;
    Pair(int x, int y, TreeNode node){
        this.x = x;
        this.y = y;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        TreeMap<Integer, List<int[]>> map = new TreeMap();
        Queue<Pair> q = new LinkedList();
        q.offer(new Pair(0, 0, root));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            TreeNode node = p.node;
            map.putIfAbsent(x, new ArrayList());
            map.get(x).add(new int[]{y, node.val});
            
            if(node.left != null) q.offer(new Pair(x-1, y+1, node.left));
            if(node.right != null) q.offer(new Pair(x+1, y+1, node.right));
        }
        for(List<int[]> list: map.values()){
            Collections.sort(list, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<Integer> curr = new ArrayList();
            for(int[] arr : list){
                curr.add(arr[1]);   
            }
            result.add(curr);
        }
        return result;
    }
}