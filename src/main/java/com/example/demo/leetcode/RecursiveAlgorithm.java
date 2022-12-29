package com.example.demo.leetcode;

/**
 * 递归算法练习
 */
public class RecursiveAlgorithm {

    public static void main(String[] args) {
//        System.out.println(f1(3));
//        System.out.println(f2(4));
//        System.out.println(f3(4));

//        Node node = new Node(1);
//        Node node1 = new Node(2);
//        Node node2 = new Node(3);
//        Node node3 = new Node(4);
//        node.next = node1;
//        node.next.next = node2;
//        node.next.next.next = node3;
//        node.next.next.next.next = null;
//        System.out.println(reverseNode(node));
//        System.out.println(f4(node));



        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = -1;
        }
        System.out.println(f21(9, arr));

    }


    /**
     * n的阶乘
     */
    public static int f1(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f1(n - 1);
    }

    /**
     * 斐波那契数列
     *
     * @param n
     * @return
     */
    public static int f2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return f2(n - 1) + f2(n - 2);
    }

    /**
     * 斐波那契数列(递归优化)
     *
     * @param n
     * @return
     */
    public static int f21(int n, int[] arr) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (arr[n] != -1) {
            return arr[n];
        } else {
            //将计算过程中的数据暂存到数组中
            arr[n] = f2(n - 1) + f2(n - 2);
        }
        return arr[n];
    }


    /**
     * 青蛙跳台阶，可以一个，可以两个 问一共有多少跳法
     *
     * @param n
     * @return
     */
    public static int f3(int n) {
        if (n <= 2) {
            return n;
        }
        return f3(n - 1) + f3(n - 2);
    }


    /**
     * 反转链表(非递归)
     *
     * @param head
     */
    public static Node reverseNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * 链表反转（递归版）
     * 实例数据 1->2->3-4
     *
     * @param head
     * @return
     */
    public static Node f4(Node head) {
        if (head == null || head.next == null) {
            //压栈，第一次返回的是最后一个节点4
            return head;
        }
        //返回的是当前节点的上一个节点，比如当return head为节点4时，此时newList节点为3->4，此时的head为上一层的节点3
        Node newList = f4(head.next);
        //后面对head指针的操作即为对newList节点的操作。
        Node t1 = head.next;
        //第一次完成3->4   到   4-3节点指针的反转，将4指向null，断开之前正向指针
        t1.next = head;
        head.next = null;
        return newList;
    }


}
