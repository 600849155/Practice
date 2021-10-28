package com.algorithm.linked;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/5/4 1:50
 */
public class LeetCode21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);

        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
                pre = pre.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
                pre = pre.next;
            }
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        pre.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode red1 = new ListNode(1);
        ListNode red2 = new ListNode(2);
        ListNode red3 = new ListNode(3);
        red1.next = red2;
        red2.next = red3;

        ListNode blue1 = new ListNode(4);
        ListNode blue2 = new ListNode(5);
        ListNode blue3 = new ListNode(6);
        blue1.next = blue2;
        blue2.next = blue3;
        final ListNode listNode = mergeTwoLists(red1, blue1);
        System.out.println(listNode);
    }
}
