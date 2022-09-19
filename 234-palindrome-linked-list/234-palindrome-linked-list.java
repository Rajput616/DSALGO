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
    ListNode prev;
    boolean ans = true;
    public boolean isPalindrome(ListNode head) {
        prev = head;
        checkPalin(head);
        return ans;
    }
    private void checkPalin(ListNode head){
        if(head == null) return;
        checkPalin(head.next);
        if(head.val != prev.val) ans = false;
        prev = prev.next;
    }
}