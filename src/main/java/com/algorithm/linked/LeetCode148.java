package com.algorithm.linked;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/11/8 0:24
 */
public class LeetCode148 {
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int k = 0;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            k++;
        }
//        for (int i = 0; i < k; i++) {
        ListNode preA = head;
        ListNode preB = head.next;
        while (preB.next != null) {

            if (preA.val > preB.val) {
                ListNode temp = preB.next;
                preB.next = preA;
                preA.next = temp;
                preA = preB;
                preB = temp;
            } else {
                preA = preA.next;
                preB = preB.next;
            }

        }
//        }

        return head;
    }

    public static void main(String[] args) {
        final ListNode A = new ListNode(4);
        final ListNode B = new ListNode(2);
        final ListNode C = new ListNode(1);
        final ListNode D = new ListNode(3);

        A.next = B;
        B.next = C;
        C.next = D;
        final ListNode node = sortList(A);
        System.out.println(node);
    }

}
