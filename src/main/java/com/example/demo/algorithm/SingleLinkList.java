package com.example.demo.algorithm;


/**
 * @author ansonglin
 * @className SingleLinkList
 * @description TODO
 * @date 2020/6/19 17:39
 * @cersion 1.0
 **/
public class SingleLinkList {

    private int size;
    private Node head;

    public Object addHead(Object obj){
        Node newHead = new Node(obj);
        if(size == 0){
          head = newHead;
        }else {
            newHead.next = head;
            head = newHead;
        }
        size ++;
        return obj;
    }

    public Object delHead(){
     Object obj = head.obj;
     head = head.next;
     size --;
     return obj;
    }

    public Node find(Object obj){
        Node node = head;
        int tempSize = size;
        while (tempSize > 0){
            if(node.obj.equals(obj)){
                return node;
            }else {
                node = node.next;
            }
            tempSize --;
        }
        return node;
    }

    public boolean delNode(Object obj){
      if(size == 0){
          return false;
      }
      Node current = head;
      Node previous = head;
      while (current.obj != obj){
          if(current.next == null){
              return false;
          }else {
              previous = current;
              current = current.next;
          }
      }

      if(current == head){
          head = current.next;
          size --;
      }else {
          previous.next = current.next;
          size --;
      }
      return true;
    }

    public class Node{
        private Object obj;
        private Node next;
        public Node(Object obj){
          this.obj = obj;
        }
    }
}
   