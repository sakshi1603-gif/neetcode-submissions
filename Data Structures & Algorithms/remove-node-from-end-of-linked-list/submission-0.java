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
        // two pass aproach
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int pos = len - n;
        if (pos == 0) {
            return head.next;
        }
        ListNode curr1 = head;
        for (int i = 0; i < pos - 1; i++) {
            curr1 = curr1.next;
        }
        curr1.next = curr1.next.next;
        return head;
    }
}
