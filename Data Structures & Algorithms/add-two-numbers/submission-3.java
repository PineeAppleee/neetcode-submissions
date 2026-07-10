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
        int carry = 0;
        ListNode temp = new ListNode();
        ListNode forward = temp;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
                int rem = sum % 10;
                ListNode curr = new ListNode(rem);
                forward.next = curr;
                forward = curr;
            } else {
                ListNode curr = new ListNode(sum);
                forward.next = curr;
                forward = curr;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
                int rem = sum % 10;
                ListNode curr = new ListNode(rem);
                forward.next = curr;
                forward = curr;
            } else {
                ListNode curr = new ListNode(sum);
                forward.next = curr;
                forward = curr;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
                int rem = sum % 10;
                ListNode curr = new ListNode(rem);
                forward.next = curr;
                forward = curr;
            } else {
                ListNode curr = new ListNode(sum);
                forward.next = curr;
                forward = curr;
            }
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            forward.next = curr;
            forward = curr;
        }

        return temp.next;
    }
}
