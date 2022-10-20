/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                sb.append("n,");
                continue;
            } 
            sb.append(node.val + ",");
            q.offer(node.left);
            q.offer(node.right);
        }
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList();
        int index = 1;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!values[index].equals("n")){
                node.left = new TreeNode(Integer.parseInt(values[index]));
                q.offer(node.left);
               
            } 
            index++;
            if(!values[index].equals("n")){
                node.right = new TreeNode(Integer.parseInt(values[index]));
                q.offer(node.right);
                
            } 
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));