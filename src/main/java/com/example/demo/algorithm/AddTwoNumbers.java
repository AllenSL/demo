package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className AddTwoNumbers
 * @description TODO
 * @date 2021/2/25 1:55 下午
 * @cersion 1.0
 **/
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = null;

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        listNode2.next.next.next = null;
//     addTwoNumbers(listNode,listNode2);
        reverseList1(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        while (l1 != null || l2 != null || temp != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + temp;
            temp = sumVal / 10;
            p.next = new ListNode(sumVal % 10);
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return l3.next;
    }

    // 1.就地反转法
    public static ListNode reverseList1(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode pCur = prev.next;
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }
        return dummy.next;
    }

    public void test(ListNode node) {
        if (null == node) {
            return;
        }
        ListNode list = new ListNode(-1);
        ListNode pre = node;
        ListNode end = pre.next;
        while (end != null) {
            //end 从单链表异常
            pre.next = end.next;
            //指向头部
            end.next = pre;

            pre.next = end;

        }
    }

}
   