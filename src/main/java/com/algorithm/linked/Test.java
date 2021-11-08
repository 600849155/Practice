package com.algorithm.linked;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/10/29 23:32
 */
public class Test {

    public static void main(String[] args) {
        final ListNode A = new ListNode(1);
        final ListNode B = new ListNode(2);
        final ListNode C = new ListNode(3);
        final ListNode D = new ListNode(4);
        final ListNode E = new ListNode(5);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = null;

        ListNode head = A;
        ListNode preA = A;
        ListNode preB = null;
        while (preA.next != null) {
            preA = preA.next;
            preB = preA.next;
            System.out.println(preA.val);
            System.out.println(preB.val);

        }
    }
}
