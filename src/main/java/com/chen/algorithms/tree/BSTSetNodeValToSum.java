package com.chen.algorithms.tree;

/**
 * BST转化累加树
 * 大概意思每个节点的值=比他大的节点值+原自身值 -538,1038
 *
 * @author Redamancy
 * @date 2022/3/24 - 20:51
 */
public class BSTSetNodeValToSum {

    /**
     * 记录每个节点的值
     */
    private static int sum = 0;

    public static void main(String[] args) {

        TreeNode root = getRoot();
        traverse(root);
        //整理前：中序root:1,2,3,4,5,6
        //整理后：中序root:21,20,18,15,11,6
        mid(root);

        //其他方法：引入size字段
        // 通过计算每个节点【左侧】有多少节点，得出自己的排名-写不来

    }

    /**
     * 每个节点的值为比他的节点之和+自身值
     * 可以降序排序，递归求和+自身值
     * @param root
     */
    private static void traverse(TreeNode root){
        if (root == null){
            return;
        }

        traverse(root.getRight());
        sum += root.getValue();
        root.setValue(sum);
        traverse(root.getLeft());
    }

    private static void mid(TreeNode root){
        if (root == null){
            return;
        }
        mid(root.getLeft());
        System.out.println(root.getValue());
        mid(root.getRight());
    }

    private static TreeNode getRoot(){
        TreeNode root = new TreeNode();
        root.setValue(5);
        TreeNode rootLeft = new TreeNode();
        rootLeft.setValue(3);
        TreeNode rootRight = new TreeNode();
        rootRight.setValue(6);
        TreeNode leftLeft = new TreeNode();
        leftLeft.setValue(2);
        TreeNode leftRight = new TreeNode();
        leftRight.setValue(4);
        TreeNode minLeft = new TreeNode();
        minLeft.setValue(1);
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        rootLeft.setLeft(leftLeft);
        rootLeft.setRight(leftRight);
        leftLeft.setLeft(minLeft);

        return root;
    }
}
