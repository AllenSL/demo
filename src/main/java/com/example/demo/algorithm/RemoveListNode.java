package com.example.demo.algorithm;

/**
 * 移除指定值的节点
 */
public class RemoveListNode {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = null;
        ListNode listNode1 = removeNode(listNode, 4);
        System.out.println(listNode1);
    }

    public static ListNode removeNode(ListNode head, int num) {
        //先移除头节点值是num的node
        while (head != null) {
            if (head.val != num) {
                break;
            }
            head = head.next;
        }
        //遍历剩下链表，移除node值为num的节点
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
