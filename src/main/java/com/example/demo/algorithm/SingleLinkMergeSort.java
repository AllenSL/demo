package com.example.demo.algorithm;
import com.example.demo.algorithm.Test.Node;

/**
 * @author ansonglin
 * @className SingleLinkMergeSort
 * @description TODO
 * @date 2020/10/14 17:02
 * @cersion 1.0
 **/
public class SingleLinkMergeSort {



    public static Node mergeSort(Node head){
        if(head==null || head.next==null)    return head;
        //获取链表中间节点
        Node mid = getMid(head);

        //把链表从之间拆分为两个链表：head和second两个子链表
        Node second = mid.next;
        mid.next = null;

        //对两个子链表排序
        return merge(mergeSort(head),mergeSort(second));
    }

    //两个有序链表的归并
    public static Node merge(Node l1,Node l2){
        //辅助节点，排好序的节点将会链接到dummy后面
        Node dummy = new Node(0);
       //tail指向最后一个排好序的节点
        Node tail = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            //移动tail指针
            tail = tail.next;
        }

        if(l1!=null)
            tail.next = l1;
        else
            tail.next = l2;

        return dummy.next;

    }

    //返回链表之间节点
    public static Node getMid(Node head){
        if(head==null ||head.next==null)    return head;

        Node slow = head;
        Node faster = head.next;
        while(faster!=null&&faster.next!=null){
            slow = slow.next;
            faster = faster.next.next;
        }
        return slow;
    }



    public static void main(String[] args) {
        Node head = new Node(0);
        Node l1 = new Node(2);
        Node l2 = new Node(5);
        Node l3 = new Node(3);
        Node l4 = new Node(8);
        Node l5 = new Node(4);
        Node l6 = new Node(2);
        Node l7 = new Node(1);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        Node p = head;
        while (p.next != null) {
            System.out.print(p.val);
            p = p.next;
        }
        System.out.print(p.val);
        System.out.println();

        SingleLinkMergeSort.mergeSort(head);

        p = head;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }

}
