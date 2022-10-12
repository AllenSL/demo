package com.example.demo.algorithm.链表;

import com.example.demo.algorithm.ListNode;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class NodeTest {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        listNode.next.next.next.next = null;
        System.out.println(isPalindrome2(listNode));
    }

    public static ListNode midOrUpMidNode(ListNode node) {
        if (node == null || node.next == null || node.next.next == null) {
            return node;
        }

        ListNode slow = node.next;
        ListNode fast = node.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 是否是回文
     *
     * @param node
     * @return
     */
    public static boolean isPalindrome(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = node;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (node != null) {
            if (node.val != stack.pop().val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode node) {
        boolean res = true;
        ListNode slow = node.next;
        ListNode fast = node.next.next;
        //快慢指针找链表中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rTemp = slow;
        ListNode slowCopy = slow;
        ListNode pre = null;

        //右边链表反转
        while (slowCopy != null) {
            //缓存fast下一个指针引用
            ListNode tem = slowCopy.next;
            slowCopy.next = pre;
            pre = slowCopy;
            slowCopy = tem;
        }

        ListNode tempNode = pre;
        //左右链表比较
        while (pre != null) {
            if (pre.val != node.val) {
                res = false;
                break;
            }
            pre = pre.next;
            node = node.next;
        }
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        return res;
    }


}
