package com.example.demo.leetcode;

import com.example.demo.algorithm.ListNode;

public class addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1= l1,p2=l2;
        ListNode head = new ListNode(-1);
        ListNode p= head;
        //进位值
        int carry = 0,newVal = 0;
        while ( p1 != null || p2 != null || carry>0){
            newVal = (p1==null?0:p1.getVal())+(p2==null?0:p2.getVal())+carry;
            carry = newVal/10;
            newVal %=carry;
            p.next= new ListNode(newVal);
            p1= p1==null?null:p1.next;
            p2= p2==null?null:p2.next;
            p=p.next;
        }
        return p.next;
    }

    public static void main(String[] args) {
        System.out.println(23%2);
    }
}
