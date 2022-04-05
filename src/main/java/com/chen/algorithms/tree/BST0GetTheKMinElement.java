package com.chen.algorithms.tree;

/**
 * 二叉搜索树环节
 * 二叉搜索树中第K小的元素-二叉搜索树的中序遍历就是一个升序的有序排序
 * heiheihei
 *
 * @author Redamancy
 * @date 2022/3/24 - 20:28
 */
public class BST0GetTheKMinElement {

    /**
     * 第k小的值
     */
    private static int res = 0;

    /**
     * 当前节点排序
     */
    private static int rank = 0;


    public static void main(String[] args) {
        TreeNode root = getRoot();
        int k = 4;
        traverse(root,k);
        System.out.println("第"+k+"小的节点是："+res);
        mid(root);
    }

    private static void traverse(TreeNode root,int k){
        if (root == null){
            return;
        }
        traverse(root.getLeft(),k);
        rank++;
        if (k == rank){
            res = root.getValue();
            return;
        }
        traverse(root.getRight(),k);
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
