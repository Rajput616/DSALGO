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

class Tuple{
    TreeNode node;
    int x, y;
    Tuple(TreeNode node, int x, int y){
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();
        if(root == null) return ans;
        Queue<Tuple> q = new LinkedList();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Tuple front = q.poll();
                TreeNode node = front.node;
                int x = front.x;
                int y = front.y;
                map.putIfAbsent(x, new TreeMap());
                map.get(x).putIfAbsent(y, new PriorityQueue());
                map.get(x).get(y).offer(node.val);
                if(node.left != null) q.offer(new Tuple(node.left, x-1, y+1));
                if(node.right != null) q.offer(new Tuple(node.right, x+1, y+1));
            }
        }
        int index = 0;
        for(Map<Integer, PriorityQueue<Integer>> m : map.values()){
            ans.add(new ArrayList());
            for(PriorityQueue<Integer> pq : m.values()){
                while(!pq.isEmpty()){
                    ans.get(index).add(pq.poll());
                }
            }
            index++;
        }
        return ans;
    }
}