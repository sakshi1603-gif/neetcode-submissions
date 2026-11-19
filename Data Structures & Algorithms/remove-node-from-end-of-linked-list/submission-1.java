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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy ;
        ListNode fast = dummy ;
        for(int i = 0;i<n ;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next ;
    }
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     int len = 0;
    //     ListNode curr = head;
    //     while (curr != null) {
    //         len++;
    //         curr = curr.next;
    //     }
    //     int pos = len - n;
    //     if (pos == 0) {
    //         return head.next;
    //     }
    //     ListNode curr1 = head;
    //     for (int i = 0; i < pos - 1; i++) {
    //         curr1 = curr1.next;
    //     }
    //     curr1.next = curr1.next.next;
    //     return head;
    // }
}
