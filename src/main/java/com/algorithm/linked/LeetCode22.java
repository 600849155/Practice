package com.algorithm.linked;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/11/4 0:26
 */
public class LeetCode22 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        LinkedList<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode returnListNode = null;
        for (int i = 0; i < k; i++) {
            returnListNode = stack.pollFirst();
        }
        return returnListNode;
    }

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
        final ListNode node = getKthFromEnd(A, 2);
        System.out.println(node);
    }

}
