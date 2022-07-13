package com.example.demo.leetcode;

import java.util.Stack;

public class trap {

    public static int trap(int[] height) {
        if (height == null) {
            return 0;
         }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                    // i - stackTop - 1 是雨水的宽度。
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(4);
       int[]  param = new int[]{5,1,0,0,1,2,4};
        System.out.println(trap(param));
        System.out.println(stack.pop());
        System.out.println();
    }

    /**
     * 我的接雨水题测试
     * @param height
     * @return
     */
    public int myArap(int[] height){

        int length = height.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer curIdx = stack.pop();
                //相邻的相等的元素移除
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans = (Math.min(height[stack.peek()], height[i]) - height[curIdx]) * (i - stack.peek() - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}