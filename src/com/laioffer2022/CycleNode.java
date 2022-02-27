package com.laioffer2022;


public class CycleNode {
    public ListNode cycleNode(ListNode head) {
        // Corner case
        if (head == null) {
            return null;
        }
        // Using fast and slow pointer to check if there is cycle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
