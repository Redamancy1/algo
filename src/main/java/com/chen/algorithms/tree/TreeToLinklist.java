package com.chen.algorithms.tree;

/**
 * 将二叉树展开为链表-114
 * input:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *output: 4213769
 *
 * @author Redamancy
 * @date 2022/3/11 - 20:47
 */
public class TreeToLinklist {

    public static void main(String[] args) {
        TreeNode root = getRoot();
        toLinkList(root);
        //4213769
        while(root!=null){
            System.out.println(root.getValue());
            root = root.getRight();
        }
    }

    private static void toLinkList(TreeNode root){
        if (root == null){
            return;
        }
        //先将根节点的左右两侧节点处理好成直线链表
        toLinkList(root.getLeft());
        toLinkList(root.getRight());
        //保存处理好的左右子节点树
        TreeNode leftLink = root.getLeft();
        TreeNode rightLink = root.getRight();
        if (leftLink != null){
            //调整左右子树
            root.setLeft(null);
            root.setRight(leftLink);
            //将原本的右子树拼接到当前右子树的末端
            while (leftLink.getRight() != null){
                leftLink = leftLink.getRight();
            }
            leftLink.setRight(rightLink);
            //root.setRight(leftLink)这里的leftLink已经不是最初的值
            // while循环变成最深的节点值，不能放在此处
        }

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
