package com.algorithm.linked;

import java.util.Objects;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/10/25 18:21
 */
public class LeetCode92 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode midNode = null;
        ListNode beginNode = null;
        ListNode endNode = null;
        //preB = left
        ListNode preB = head;
        //preC = right
        ListNode preC = head;
        // preC -> 2
        while (preC.next != null && preC.val != right) {
            preC = preC.next;
            endNode = preC.next;
        }
        // preB -> 4
        while (preB.next != null && preB.val != left) {
            beginNode = preB;
            preB = preB.next;
        }

        // 2,3,4 -> 4,3,2
        while (preB.next != null && preB != preC.next) {
            ListNode temp = preB.next;
            preB.next = midNode;
            midNode = preB;
            preB = temp;
        }
        //1 -> 4,3,2
        if (beginNode != null) {
            beginNode.next = midNode;
        }

        // midPre 指向 midNode 最后一个元素
        ListNode midPre = midNode;
        while (midPre != null && midPre.next != null) {
            midPre = midPre.next;
        }
        // 将 midNode 的最后一个元素指向 5
        if (midPre != null) {
            midPre.next = endNode;
        }


        return beginNode;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode listNode = reverseBetween(a1, 2, 4);
        System.out.println(listNode);
    }
}
