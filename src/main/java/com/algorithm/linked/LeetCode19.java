package com.algorithm.linked;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/11/12 15:41
 */
public class LeetCode19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode lengthCur = head;
        while (lengthCur != null) {
            lengthCur = lengthCur.next;
            length++;
        }

        if (n == 1 && length == 1) {
            return null;
        }

        ListNode headCur = head;
        int k = length - n;
        // 移动到K前面的位置
        for (int i = 0; i < k - 1; i++) {
            headCur = headCur.next;
        }
        ListNode temp = headCur.next.next;
        headCur.next = temp;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode listNode = removeNthFromEnd(node1, 2);
        System.out.println(listNode);
    }
}
