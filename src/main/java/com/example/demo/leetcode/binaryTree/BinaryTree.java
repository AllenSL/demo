package com.example.demo.leetcode.binaryTree;

import java.util.*;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(9);
        binaryTreeNode.left = new BinaryTreeNode(8);
        binaryTreeNode.right = new BinaryTreeNode(10);
        binaryTreeNode.left.left = new BinaryTreeNode(7);
        binaryTreeNode.right.right = new BinaryTreeNode(23);
//        sequencetraversal(binarytreenode);

//        List<Integer> list = inorderTraversal(binaryTreeNode);

        TreeNode treeNode = new TreeNode(9);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(10);
        treeNode.right.left = new TreeNode(21);
        treeNode.right.right = new TreeNode(23);
        int depth = getDepth(treeNode);
        System.out.println(depth);
    }

    List<Integer> list = new ArrayList<>();
    public static List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    static void inorderTraversal(BinaryTreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root.value);
        inorderTraversal(root.right,list);
    }

    /**
     *
     * 先序遍历: 先头节点，再左节点，再右节点
     * 中序遍历： 左头右
     * 后序遍历： 左右头
     */


    /**
     * 先序遍历
     *
     * @param head
     */
    public static void pre(BinaryTreeNode head) {
        if (null == head) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    public static void noRecursivePre(BinaryTreeNode head) {
        if (head != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }


    /**
     * 层序打印
     *
     * @param head
     */
    public static void sequenceTraversal(BinaryTreeNode head) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        if (head != null) {
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                System.out.println(head.value);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
        }
    }

    /**
     * 统计二叉树最大宽度
     * 思路:  新层到来去抓老层
     *
     * @param head
     */
    public static void maxWidth(BinaryTreeNode head) {
        Queue<BinaryTreeNode> quene = new LinkedList<>();
        HashMap<BinaryTreeNode, Integer> map = new HashMap<>();
        int maxLength = 0;
        int curLevel = 1;
        int curLevelNodes = 0; //当前curLevel层，宽度目前是多少
        if (head != null) {
            quene.add(head);
            map.put(head, 1);
            while (!quene.isEmpty()) {
                head = quene.poll();
                int curNodeLevel = map.get(head);

                //下面两个if是为下一层统计做准备
                if (head.left != null) {
                    map.put(head.left, curNodeLevel + 1);
                    quene.add(head.left);
                }
                if (head.right != null) {
                    map.put(head.right, curNodeLevel + 1);
                    quene.add(head.right);
                }

                //这个if是统计的当前层节点数
                if (curNodeLevel == curLevel) {
                    curLevelNodes++;
                } else {
                    maxLength = Math.max(maxLength, curLevelNodes);
                    curLevel++;
                    //当前层节点数初始值
                    curLevelNodes = 1;
                }
            }
            maxLength = Math.max(maxLength, curLevelNodes);
        }
    }


    /**
     * 获取二叉树的深度
     * @param node
     * @return
     */
    public static int getDepth(TreeNode node){
        if(node == null) return 0;
        System.out.println(node.val);
        int leftdepth = getDepth(node.left);
        int rightdepth = getDepth(node.right);
        int max = Math.max(leftdepth, rightdepth) + 1;
        System.out.println(max);
        return max;
    }









    private class ReturnRes{
        boolean isB;
        int depth;
        public ReturnRes(boolean isB,int depth){
            this.isB = isB;
            this.depth = depth;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        //整体思路有点像后序遍历
        ReturnRes res = dfs(root);
        return res.isB;
    }

    ReturnRes dfs(TreeNode root){
        //递归终止条件
        if(root == null){
            return new ReturnRes(true,0);
        }
        ReturnRes left = dfs(root.left);
        ReturnRes right = dfs(root.right);

        //判断是否是二叉树
        if(left.isB == false || right.isB == false){
            return new ReturnRes(false,0);
        }
        //判断左右两棵树的高度差
        if(Math.abs(left.depth-right.depth)>1){
            return new ReturnRes(false,0);
        }

        return new ReturnRes(true,Math.max(left.depth,right.depth)+1);
    }




}
