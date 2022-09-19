/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }
        ListNode front = new ListNode(0), dummy = front;
        front.next = head;
        ListNode prev = head;
        while(size >= k){
            int count = 1;
            while(count < k){
                curr = prev.next;
                prev.next = curr.next;
                curr.next = front.next;
                front.next = curr;
                count++;
            }
            front = prev;
            prev = prev.next;
            size -= k;
        }
        return dummy.next;
    }
}