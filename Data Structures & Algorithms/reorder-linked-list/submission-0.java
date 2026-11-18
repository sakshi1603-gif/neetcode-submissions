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

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode curr1 = reverseList(slow.next);
        slow.next = null;

        // Merge two halves
        ListNode curr = head;

        while (curr1 != null) {

            ListNode next1 = curr.next;
            ListNode next2 = curr1.next;

            curr.next = curr1;
            curr1.next = next1;

            curr = next1;
            curr1 = next2;
        }
    }
}

