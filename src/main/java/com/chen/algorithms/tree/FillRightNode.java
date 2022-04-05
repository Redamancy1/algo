package com.chen.algorithms.tree;

/**
 * 填充
 *
 * @author Redamancy
 * @date 2022/3/19 - 20:17
 */
public class FillRightNode {

    public static void main(String[] args) {
        TreeNode root = getRoot();
        connect(root);
        System.out.println(root.getNext());
        //7
        System.out.println(root.getLeft().getNext().getValue());
        //6
        System.out.println(root.getLeft().getRight().getNext().getValue());
    }

    private static TreeNode connect(TreeNode root){
        if (root == null ){
            return null;
        }
        //处理子节点
        connectTwoNode(root.getLeft(),root.getRight());
        return root;
    }

    private static void connectTwoNode(TreeNode left,TreeNode right){
        if (left == null || right == null){
            return;
        }
        left.setNext(right);
        //连接相同父节点的两个子节点
        connectTwoNode(left.getLeft(),left.getRight());
        connectTwoNode(right.getLeft(),left.getRight());
        //连接非同父节点的两个子节点-  leftRight && RightLeft
        connectTwoNode(left.getRight(),right.getLeft());
    }

    private static TreeNode getRoot(){
        TreeNode root = new TreeNode();
        TreeNode rootLeft = new TreeNode();
        TreeNode rootRight = new TreeNode();
        TreeNode leftLeft = new TreeNode();
        TreeNode leftRight = new TreeNode();
        TreeNode rightLeft = new TreeNode();
        TreeNode rightRight = new TreeNode();
        root.setValue(4);
        rootLeft.setValue(2);
        rootRight.setValue(7);
        leftLeft.setValue(1);
        leftRight.setValue(3);
        rightLeft.setValue(6);
        rightRight.setValue(9);
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        rootLeft.setLeft(leftLeft);
        rootLeft.setRight(leftRight);
        rootRight.setLeft(rightLeft);
        rootRight.setRight(rightRight);
        return root;
    }
}
