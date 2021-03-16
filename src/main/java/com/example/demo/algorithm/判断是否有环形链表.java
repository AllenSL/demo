package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ansonglin
 * @className 判断是否有环形链表
 * @description TODO
 * @date 2021/3/4 9:41 下午
 * @cersion 1.0
 **/
public class 判断是否有环形链表 {

    public boolean hasCycle(ListNode head) {
        ListNode tempNode = head;
        Map<ListNode, ListNode> map = new HashMap<>();
        while (head != null) {
            if (map.get(tempNode) != null) {
                return true;
            }
            map.put(tempNode, tempNode);
            tempNode = tempNode.next;
            if (tempNode == null) {
                return false;
            }
        }
        return true;
    }
}
   