package com.chen.algorithms.tree;

import org.springframework.util.StopWatch;

/**
 * 二叉搜索树中查找值
 *
 * @author Redamancy
 * @date 2022/3/24 - 21:01
 */
public class BSTSearchTarget {
    public static void main(String[] args) {
        TreeNode root = getRoot();
        int num = 3;

        StopWatch watch = new StopWatch();
        watch.start("二叉搜索树");
        TreeNode target = searchNode(root,num);
        System.out.println("找到你了："+target);
        watch.stop();

        watch.start("平平凡凡二叉树");
        System.out.println(searchNormalTree(root,num));
        watch.stop();
        //数据太少，算了不好对比
        System.out.println(watch.prettyPrint());
    }

    private static TreeNode searchNode(TreeNode root,int target){
        if (root == null){
            return null;
        }
        if (target == root.getValue()) {
            return root;
        }
        //判断当前root值与target大小关系
        if (target < root.getValue()) {
            return searchNode(root.getLeft(),target);
        }
        if (target > root.getValue()) {
            return searchNode(root.getRight(),target);
        }
        return root;
    }

    /**
     * 普通二叉树就没办法拉，只能遍历所有的节点去判断是否为target值
     *
     * @param root
     * @param target
     * @return
     */
    private static TreeNode searchNormalTree(TreeNode root,int target){
        if (root == null) {
            return null;
        }
        if (root.getValue() == target) {
            return root;
        }
        // 当前节点没找到就递归地去左右子树寻找
        TreeNode left = searchNormalTree(root.getLeft(), target);
        TreeNode right = searchNormalTree(root.getRight(), target);

        return left != null ? left : right;
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
