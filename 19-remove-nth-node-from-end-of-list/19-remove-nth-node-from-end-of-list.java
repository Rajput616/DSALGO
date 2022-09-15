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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(count++ < n-1) head = head.next;
        ListNode prev = dummy;
        while(head.next != null){
            head = head.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}