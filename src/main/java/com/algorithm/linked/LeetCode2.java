package com.algorithm.linked;


/**
 * @author WhomHim
 * @description
 * @date Create in 2021/11/4 10:40
 */
public class LeetCode2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // res 是第三条链表
        ListNode res = new ListNode();
        ListNode preHead = res;
        //表示进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            //如果其中有一个到达结尾了，那么这个链表这一位的的数字就为0。
            int a;
            if (l1 == null) {
                a = 0;
            } else {
                a = l1.val;
            }
            int b;
            if (l2 == null) {
                b = 0;
            } else {
                b = l2.val;
            }
            //两个链表的两位相加
            int sum = a + b + carry;
            //大于10进位
            carry = sum / 10;
            //进位完剩下的余数
            sum %= 10;
            //创建一个节点接入res后面
            preHead.next = new ListNode(sum);
            preHead = preHead.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //如果最后还有进位的话，增加一个节点
        if (carry == 1) {
            preHead.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode red1 = new ListNode(2);
        ListNode red2 = new ListNode(4);
        ListNode red3 = new ListNode(9);
        red1.next = red2;
        red2.next = red3;

        ListNode blue1 = new ListNode(5);
        ListNode blue2 = new ListNode(6);
        ListNode blue3 = new ListNode(4);
        ListNode blue4 = new ListNode(9);

        blue1.next = blue2;
        blue2.next = blue3;
        blue3.next = blue4;

        ListNode listNode = addTwoNumbers(red1, blue1);
        System.out.println(listNode);
    }
}
