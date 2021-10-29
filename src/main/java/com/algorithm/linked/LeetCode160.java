package com.algorithm.linked;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/10/25 16:57
 */
public class LeetCode160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode preA = headA;
        ListNode preB = headB;
        ListNode bHead = headB;

        while (preA.next != null) {
            while (preB.next != null) {
                if (preA == preB) {
                    return preA;
                }
                preB = preB.next;
            }
            preB = bHead;
            headA = headA.next;
            preA = headA;
        }
        return null;
    }

    public static void main(String[] args) {
        //8
        //[4,1,8,4,5]
        //[5,6,1,8,4,5]
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);

        b1.next = b2;
        b2.next = b3;
        b3.next = a3;

        ListNode intersectionNode = getIntersectionNode(a1, b1);
        System.out.println(intersectionNode);
    }

}
