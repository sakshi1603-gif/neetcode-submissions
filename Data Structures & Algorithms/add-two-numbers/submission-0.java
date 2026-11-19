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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lp1 = l1;
        ListNode lp2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode lp3 = dummy;
        int carry = 0;
        while (lp1 != null || lp2 != null || carry != 0) {
            int v1 = 0;
            if (lp1 != null) {
                v1 = lp1.val;
            }
            int v2 = 0;
            if (lp2 != null) {
                v2 = lp2.val;
            }
            int add = v1 + v2 + carry;
            carry = add / 10;
            int val = add % 10;
            ListNode newNode = new ListNode(val);
            lp3.next = newNode;
            if (lp1 != null) {
                lp1 = lp1.next;
            }
            if (lp2 != null) {
                lp2 = lp2.next;
            }
            lp3 = newNode;
        }
        return dummy.next;
    }
}
