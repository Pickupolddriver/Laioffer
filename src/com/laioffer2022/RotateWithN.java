package com.laioffer2022;

public class RotateWithN {
    public static void main(String[] args) {
        RotateWithN rotateWithN = new RotateWithN();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode res = rotateWithN.reverseAlternate(one);
        System.out.println(res.value);
    }

    public ListNode reverseAlternate(ListNode head) {
        // Corner case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode OddHead = new ListNode(0);
        ListNode currOdd = OddHead;
        ListNode EvenHead = new ListNode(0);
        ListNode currEven = EvenHead;
        ListNode curr = head;
        ListNode nex = null;
        boolean flipFlag = true;
        while (curr != null) {
            nex = curr.next;
            if (flipFlag) {
                currOdd.next = curr;
                currOdd = currOdd.next;
                currOdd.next = null;
                flipFlag = !flipFlag;
            } else {
                currEven.next = curr;
                currEven = currEven.next;
                currEven.next = null;
                flipFlag = !flipFlag;
            }
            curr = nex;
        }
        ListNode actEven = EvenHead.next;
        EvenHead.next = null;
        ListNode rev = reverseNode(actEven);
        currOdd.next = rev;
        return EvenHead.next;
    }

    public ListNode reverseNode(ListNode head) {
        // Corner case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode nex = null;
        while (curr != null) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }
}
