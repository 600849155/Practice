package com.algorithm.linked;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/10/30 1:05
 */
public class LeetCode82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode curHead = head;
        ListNode preA = head.next;
        ListNode preB = head.next.next;
        while (preA.next != null && preB.next != null) {
            if (preA.val == preB.val) {
                while (preA.val == preB.val && preB.next != null) {
                    curHead.next = preB.next;
                    preB = preB.next;
                    preA = preA.next;
                }
            } else {
                if (curHead.next != preB) {
                    curHead = curHead.next;
                }
                preA = preA.next;
                preB = preB.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        final ListNode A = new ListNode(1);
        final ListNode B = new ListNode(2);
        final ListNode C = new ListNode(3);
        final ListNode D = new ListNode(3);
        final ListNode E = new ListNode(4);
        final ListNode F = new ListNode(4);
        final ListNode G = new ListNode(5);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        F.next = G;

        final ListNode listNode = deleteDuplicates(A);
        System.out.println(listNode);
    }

}
