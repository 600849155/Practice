package com.algorithm.linked;

/**
 * @author WhomHim
 * @description <p>https://leetcode-cn.com/problems/reverse-linked-list/</p>
 * @date Create in 2021/3/13 17:21
 */
public class LeetCode206 {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        // 想象递归已经层层返回，到了最后一步
        // 以链表 1->2->3->4->5 为例，现在链表变成了 5->4->3->2->null，1->2->null（是一个链表，不是两个链表）
        // 此时 newHead是5，head是1
        final ListNode newLinkedList = reverseList(head.next);
        // 最后的操作是把链表 1->2->null 变成 2->1->null
        // head是1，head.next是2，head.next.next = head 就是2指向1，此时链表为 2->1->2
        head.next.next = head;
        // 防止链表循环，1指向null，此时链表为 2->1->null，整个链表为 5->4->3->2->1->null
        head.next = null;
        return newLinkedList;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return head;
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
        E.next = null;

        final ListNode returnListNode = reverseList(A);
        System.out.println(returnListNode);
    }
}
