package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className 删除链表倒数第N个节点, 并返回链表
 * @description
 * @date 2021/3/1 7:15 下午
 * @cersion 1.0
 **/
public class 删除链表倒数第N个节点 {
    int cur = 0;

    public ListNode removeNthFormEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        head.next = removeNthFormEnd(head.next, n);
        cur++;
        if (cur == n) {
            return head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        删除链表倒数第N个节点 s = new 删除链表倒数第N个节点();
        ListNode listNode1 = s.removeNthFormEnd(listNode, 2);
        System.out.println();
    }
}
   