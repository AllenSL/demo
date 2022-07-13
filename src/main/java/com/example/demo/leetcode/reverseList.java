package com.example.demo.leetcode;

import com.example.demo.algorithm.ListNode;

public class reverseList {

    public static ListNode process(ListNode head) {
       ListNode newHead = new ListNode();
        ListNode cur = head;
       while (cur.next != null){
           newHead.pre = cur;
           cur = cur.next;
           newHead = newHead.next;
       }
      return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = null;
        ListNode listNode1 = process(listNode);
        System.out.println(listNode1);
    }
}
