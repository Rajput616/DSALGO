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
// class Solution {
//     ListNode prev;
//     boolean ans = true;
//     public boolean isPalindrome(ListNode head) {
//         prev = head;
//         checkPalin(head);
//         return ans;
//     }
//     private void checkPalin(ListNode head){
//         if(head == null) return;
//         checkPalin(head.next);
//         if(head.val != prev.val) ans = false;
//         prev = prev.next;
//     }
// }


class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if(fast.val != slow.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode headNext = head.next;
            head.next = prev;
            prev = head;
            head = headNext;
        }
        return prev;
    }
}