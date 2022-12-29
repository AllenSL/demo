package com.example.demo.leetcode;

import com.example.demo.leetcode.binaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {


    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
        binaryTreeNode.left = new BinaryTreeNode(2);
        binaryTreeNode.right = new BinaryTreeNode(7);
        binaryTreeNode.right.left = new BinaryTreeNode(6);
        binaryTreeNode.left.left = new BinaryTreeNode(2);
        binaryTreeNode.right.right = new BinaryTreeNode(8);

        System.out.println(pathSum(binaryTreeNode, 16));
    }


    // 用全局变量res来记录结果(当然也可以将res当作当前状态的一部分放到dfs的参数列表中)。
    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        // 仔细思考dfs的状态，除了和当前的节点root、当前目标和sum有关，还和当前路径path有关。
        // (当然也可以将res当作当前状态的一部分放到dfs的参数列表中, 这里我们认为res只是一个结果收集器，与当前状态无关，放到全局变量中)
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path);
        return res;
    }

    // 因为在遍历过程中会做结果集的收集，dfs不需要返回值
    private static void dfs(BinaryTreeNode root, int sum, List<Integer> path) {
        // 终点状态1, 直接返回
        if (root == null) {
            return;
        }

        // 终点状态2，需要做退出前处理(收集新路径)
        if (root.left == null && root.right == null && root.value == sum) {
            // 标记当前状态 - 路径加入当前节点
            path.add(root.value);
            // 结果加入当前路径
            // 因为path是全局唯一对象，用来记录遍历过程中当前状态的路径，所以不能直接将path放到结果集中，需要深拷贝
            res.add(new ArrayList<>(path));
            // (还原标记) - 为了不影响后续遍历，需要回溯去掉path里的当前节点
            path.remove(path.size() - 1);
            return;
        }
        // 当前状态相关的下一个状态有两个: 比较树的左子和右子
        // 邻节点dfs之前应该做的处理(设定expectSum)
        int expectSum = sum - root.value;
        // 标记当前状态 - 路径加入当前节点
        path.add(root.value);
        dfs(root.left, expectSum, path);
        dfs(root.right, expectSum, path);
        // (还原标记) - 为了不影响后续遍历，需要回溯去掉path里的当前节点
        path.remove(path.size() - 1);
    }


}
