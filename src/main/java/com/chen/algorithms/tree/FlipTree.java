package com.chen.algorithms.tree;

/**
 * 翻转二叉树
 * input:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *output:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author Redamancy
 * @date 2022/3/15 - 20:55
 */
public class FlipTree {

    public static void main(String[] args) {
        TreeNode root = getRoot();

        FlipTree(root);
        System.out.println(root);

    }

    private static TreeNode FlipTree(TreeNode root){
        if (root == null){
            return null;
        }

        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        //左右节点继续递归交换翻转子节点
        FlipTree(root.getLeft());
        FlipTree(root.getRight());

        return root;
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
