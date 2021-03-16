package com.example.demo.algorithm;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author ansonglin
 * @className BinarySum
 * @description TODO
 * @date 2020/10/19 19:59
 * @cersion 1.0
 **/
public class BinarySum {

    public static class BinaryNode {
        BinaryNode leftNode;
        BinaryNode rightNode;
        int val;

        BinaryNode(BinaryNode leftNode, BinaryNode rightNode, int val) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BinaryNode leftLeftNode3 = new BinaryNode(null, null, 10);
        BinaryNode leftRightNode3 = new BinaryNode(null, null, 24);
        BinaryNode rightLeftNode3 = new BinaryNode(null, null, 50);
        BinaryNode rightRightNode3 = new BinaryNode(null, null, 70);
        BinaryNode leftNode2 = new BinaryNode(leftLeftNode3, leftRightNode3, 21);
        BinaryNode rightNode2 = new BinaryNode(rightLeftNode3, rightRightNode3, 65);
        BinaryNode top = new BinaryNode(leftNode2, rightNode2, 45);
        HashMap<Integer, Integer> result = Maps.newHashMap();
        sum(top, result, 0);
        System.out.println(result.get(3));
    }

    private static void sum(BinaryNode top, HashMap<Integer, Integer> result, Integer level) {
        if (top == null) {
            return;
        }
        int leveSum;
        if (result.containsKey(level)) {
            leveSum = result.get(level);
        } else {
            leveSum = 0;
        }
        leveSum += top.val;
        result.put(level, leveSum);
        sum(top.leftNode, result, level + 1);
        sum(top.rightNode, result, level + 1);
    }
}
   