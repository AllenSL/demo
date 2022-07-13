package com.example.demo.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ansonglin
 * @className ListNode
 * @description TODO
 * @date 2020/10/14 16:53
 * @cersion 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode pre;

    public ListNode(int val) {
        this.val = val;
    }
}
   