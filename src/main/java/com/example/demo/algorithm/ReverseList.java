package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className ReverseList
 * @description TODO
 * @date 2021/2/27 1:35 下午
 * @cersion 1.0
 **/
public class ReverseList {


    public static ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }

    //首先获取后续节点

    //获取当前节点

    //赋值给Null节点

    //当前节点指向下一个节点

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = null;
        ListNode listNode1 = n(listNode);
        System.out.println(listNode1);

    }

    public static ListNode n(ListNode head){

        if(head == null)return head;

        ListNode rehead = null;

        while (head != null){
         ListNode cur = head.next; //记录下一个节点
         head.next = rehead;       //rehead节点连接到head节点
         rehead = head;
         head=cur;
        }
        return rehead;
    }


}
   