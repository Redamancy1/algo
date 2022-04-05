package com.chen.algorithms.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 不同的二叉搜索树，打印 - 95
 * 给定一个正整数 n,计算 {1,2,3,... n}共有多少种BST结构
 * 并返回列表所以可能情况
 *
 * @author Redamancy
 * @date 2022/3/30 - 20:38
 */
public class BSTHowManyTreePrint {

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> list = generateTrees(n);
        System.out.println(list);
    }


    /**
     * 1、穷举root节点的所有可能。
     * 2、递归构造出左右子树的所有合法 BST。
     * 3、给root节点穷举所有左右子树的组合
     *
     * @param n
     * @return
     */
    private static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    /**
     * 构造闭区间 [lo, hi] 组成的 BST
     * 不要纠结递归过程中的执行中间结果，只要对递归的任务是什么清楚就好
     *
     * @param lo
     * @param hi
     * @return
     */
    private static List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();

        if (lo > hi) {
            res.add(null);
            return res;
        }

        // 1、穷举 root 节点的所有可能。
        for (int i = lo; i <= hi; i++) {
            // 2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            // 3、给 root 节点穷举所有左右子树的组合。
            // 相当于把左右子树可能的情况一一组合，先遍历哪个子树都可以
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode();
                    root.setValue(i);
                    root.setLeft(left);
                    root.setRight(right);
                    res.add(root);
                }
            }
        }

        return res;
    }
}
