package com.example.demo.leetcode;

/**
 * 两个链表相加
 */
public class AddTwoNumbers2 {

    public static Node addTwoNumbers(Node head1, Node head2) {
        Node l = getNodeLength(head1) > getNodeLength(head2) ? head1 : head2;
        Node s = l == head1 ? head2 : head1;
        Node curl = l;
        Node curs = s;
        //进位值
        int carry = 0;
        //总和
        int sum = 0;
        //最后一个节点
        Node lastNode = curl;
        while (curs != null && curl != null) {
            sum = curl.intVal + curs.intVal + carry;
            carry = sum / 10;
            curl.intVal = sum % 10;
            lastNode = curl;
            curl = curl.next;
            curs = curs.next;
        }

        while (curl != null) {
            sum = curl.intVal + carry;
            curl.intVal = sum % 10;
            carry = sum / 10;
            lastNode = curl;
            curl = curl.next;
        }
        if (carry > 0) {
            lastNode.next = new Node(carry);
        }
        return l;
    }


    static int getNodeLength(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }


    public static void main(String[] args) {
        Node node1 = new Node(9);
        node1.next = new Node(8);
        node1.next.next = new Node(2);
        node1.next.next.next = null;
        Node node2 = new Node(8);
        node2.next = new Node(8);
        node2.next.next = null;
        Node node = addTwoNumbers(node1, node2);
        System.out.println(node);
    }
}
