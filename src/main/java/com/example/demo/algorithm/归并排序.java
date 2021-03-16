package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className 归并排序
 * @description TODO
 * @date 2021/2/27 6:01 下午
 * @cersion 1.0
 **/
public class 归并排序 {

    public static ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        ListNode result = new ListNode();
        ListNode tail = result;
        while (node1 != null && node2 != null) {
            if (node1.val >= node2.val) {
                tail.next = node2;
                node2 = node2.next;
            } else {
                tail.next = node1;
                node1 = node1.next;
            }
            tail = tail.next;
        }
        if (node1 != null) {
            tail.next = node1;
        }
        if (node2 != null) {
            tail.next = node2;
        }
        return result.next;
    }

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(2);
//        listNode.next = new ListNode(4);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(3);
//
//
//        ListNode listNode1 = new ListNode(7);
//        listNode1.next = new ListNode(1);
//        listNode1.next.next = new ListNode(5);
//        ListNode merge = merge(listNode, listNode1);
//        System.out.println();
        int i = 0;
        int j = 0;
        System.out.println(i++);
        System.out.println(i);
        System.out.println(++j);
    }
}
   