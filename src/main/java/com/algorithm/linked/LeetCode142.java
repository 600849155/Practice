package com.algorithm.linked;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/10/26 17:30
 */
public class LeetCode142 {

    public static ListNode detectCycle(ListNode head) {
        ListNode preA = head;
        ListNode preB = head;

        while (preA.next != null) {
            while (preB.next != null) {
                preB = preB.next;
                if (preA.next == preB.next) {
                    return preA.next;
                }
            }
            preA = preA.next;
        }

        return null;
    }

    public static void main(String[] args) {
//        输入：head = [3,2,0,-4], pos = 1
//        输出：返回索引为 1 的链表节点
//        解释：链表中有一个环，其尾部连接到第二个节点。
//        ListNode a = new ListNode(3);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(0);
//        ListNode d = new ListNode(-4);
//
//        a.next = b;
//        d.next = b;
//
//        b.next = c;
//        c.next = d;
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        b.next = a;

        ListNode listNode = detectCycle(a);
        System.out.println(listNode);
    }
}
