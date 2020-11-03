package com.example.demo.algorithm;

/**
 * @author ansonglin
 * @className Test
 * @description TODO
 * @date 2020/10/14 19:42
 * @cersion 1.0
 **/
public class Test {


    public static Node merge(Node node){
        if(node==null || node.next==null){
            return node;
        }
        //分成两个链表
        Node midNode = getMidNode(node);
        Node second = midNode.next;
        midNode.next = null;
        return mergeSort(merge(node),merge(second));
    }

    private static Node mergeSort(Node n1, Node n2) {
        Node dummy = new Node(0);
        //tail指向最后一个排好序的节点
        Node tail = dummy;

        while (n1 != null && n2 != null){
            if(n1.val <= n2.val){
                tail.next = n1;
                n1 = n1.next;
            }else {
                tail.next = n2;
                n2 = n2.next;
            }
            tail = tail.next;
        }

        if (n1 != null){
            tail.next = n1;
        }

        if(n2 != null){
            tail.next = n2;
        }
        return dummy.next;
    }

    private static Node getMidNode(Node node) {
        if(node == null || node.next == null){
            return node;
        }
        Node head = node;
        Node second = node.next;
        while (second != null && second.next != null){
            head = head.next;
            second = second.next.next;
        }
       return head;
    }


    static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }

        public static void sortPrint(Node node){
            while (node != null){
             System.out.print(node.val +" ");
             node = node.next;
            }
             System.out.println();
        }
    }

  public static void main(String[] args) {
          Node node = new Node(1);
          node.next = new Node(5);
          node.next.next = new Node(4);
          node.next.next.next = new Node(3);
          node.next.next.next.next = new Node(2);
          node.next.next.next.next.next = new Node(6);
          node.next.next.next.next.next.next = null;
          Test.Node.sortPrint(node);
          Node merge = Test.merge(node);
          Test.Node.sortPrint(merge);
  }
}
   