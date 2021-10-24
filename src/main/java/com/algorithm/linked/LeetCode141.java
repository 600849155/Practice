package com.algorithm.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/10/24 17:45
 */
public class LeetCode141 {
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        final Map<ListNode, Integer> counterNodeMap = new HashMap<>();
        ListNode preA = null;
        ListNode preB = head;
        while (preB.next != null) {
            if (counterNodeMap.get(preB.next) != null) {
                return true;
            }
            counterNodeMap.put(preB, 1);
            ListNode temp = preB.next;
            preB.next = preA;
            preA = preB;
            preB = temp;

        }

        return false;
    }

    public static void main(String[] args) {
        //输入：head = [3,2,0,-4], pos = 1
        //输出：true
        //解释：链表中有一个环，其尾部连接到第二个节点。
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        node5.next = node6;
        node6.next = node5;

        final boolean b = hasCycle(node1);
        System.out.println(b);
    }
}
