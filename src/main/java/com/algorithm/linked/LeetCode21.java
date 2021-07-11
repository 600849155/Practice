package com.algorithm.linked;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/5/4 1:50
 */
public class LeetCode21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curHead;
        ListNode curRed = l1;
        ListNode curBlue = l2;
        while (curRed != null && curBlue != null) {
            ListNode redTemp = curRed.next;
            ListNode blueTemp = curBlue.next;
            if (curRed.val >= curBlue.val) {
                head.next = curBlue;
                head.next.next = curRed;
            } else {
                head.next = curRed;
                head.next.next = curBlue;
            }
            curHead = head.next.next;
            head = curHead;
            curBlue = blueTemp;
            curRed = redTemp;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode red1 = new ListNode(1);
        ListNode red2 = new ListNode(2);
        ListNode red3 = new ListNode(4);
        red1.next = red2;
        red2.next = red3;

        ListNode blue1 = new ListNode(1);
        ListNode blue2 = new ListNode(3);
        ListNode blue3 = new ListNode(4);
        blue1.next = blue2;
        blue2.next = blue3;
        final ListNode listNode = mergeTwoLists(red1, blue2);
        System.out.println(listNode);
    }
}
