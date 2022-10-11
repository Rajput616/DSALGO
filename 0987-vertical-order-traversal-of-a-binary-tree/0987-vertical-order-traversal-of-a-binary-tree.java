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
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();
        Queue<Pair> q = new LinkedList();
        q.offer(new Pair(0, 0, root));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            TreeNode node = p.node;
            map.putIfAbsent(x, new TreeMap());
            map.get(x).putIfAbsent(y, new PriorityQueue());
            map.get(x).get(y).offer(node.val);
            
            if(node.left != null) q.offer(new Pair(x-1, y+1, node.left));
            if(node.right != null) q.offer(new Pair(x+1, y+1, node.right));
        }
        for(Map<Integer, PriorityQueue<Integer>> mp: map.values()){
            List<Integer> list = new ArrayList();
            for(PriorityQueue<Integer> pq : mp.values()){
                while(!pq.isEmpty()) list.add(pq.poll());
            }
            result.add(list);
        }
        return result;
    }
}