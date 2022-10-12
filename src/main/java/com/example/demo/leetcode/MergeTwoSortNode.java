package com.example.demo.leetcode;

/**
 * 合并两个有序链表
 */
public class MergeTwoSortNode {

    static Node process(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.intVal >= head2.intVal ? head2 : head1;
        Node cur1 = head.next;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.intVal > cur2.intVal) {
                pre.next = cur2;
                cur2 = cur2.next;
            } else {
                pre.next = cur1;
                cur1 = cur1.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(6);
        node1.next.next = new Node(9);
        node1.next.next.next = null;
        Node node2 = new Node(3);
        node2.next = new Node(8);
        node2.next.next = null;
        Node node = process(node1, node2);
        System.out.println(node);
    }

}
