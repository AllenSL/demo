package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className 链表合并
 * @description TODO
 * @date 2021/3/4 4:57 下午
 * @cersion 1.0
 **/
public class 有序链表合并 {

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode listNode = new ListNode(0);
        ListNode tailNode = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tailNode.next = l1;
                l1 = l1.next;
            } else {
                tailNode.next = l2;
                l2 = l2.next;
            }
            tailNode = tailNode.next;
        }
        if (l1 != null) {
            tailNode.next = l1;
        }
        if (l2 != null) {
            tailNode.next = l2;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = listNode1;
        listNode3.next = new ListNode(2);
        mergeTwoLists(listNode1, listNode2);
    }
}
   