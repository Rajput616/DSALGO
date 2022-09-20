/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap();
        Node curr = head;
        while(curr != null){
            Node mid = new Node(curr.val);
            mid.next = curr.next;
            curr.next = mid;
            nodeMap.put(curr, mid);
            
            curr = mid.next;
        }
        curr = head;
        while(curr != null){
            Node mid = nodeMap.getOrDefault(curr.random, null);
            curr.next.random = mid;
            
            curr = curr.next.next;
        }
        
        
        Node ansHead = new Node(0), prev = ansHead;
        curr = head;
        while(curr != null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev = prev.next;
            curr = curr.next;
        }
        
        
        return ansHead.next;
    }
}