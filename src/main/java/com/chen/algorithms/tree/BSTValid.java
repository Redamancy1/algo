package com.chen.algorithms.tree;

/**
 * 判断一棵树是否符合二叉搜索树
 *
 * @author Redamancy
 * @date 2022/3/24 - 20:13
 */
public class BSTValid {

    public static void main(String[] args) {
        TreeNode root = getRoot();
        Boolean res = isValidBST(root,null,null);
        System.out.println("这个树呢是不是二叉搜索树："+res);
        root.getLeft().getRight().setValue(0);
        Boolean res2 = isValidBST(root,null,null);
        System.out.println("这个树是不是二叉搜索树："+res2);
    }

    /**
     * 通过二叉搜索树【左小右大】定义判断
     * left.val < root.val < right.val
     * 以上判断有bug，只判断了相连的root及其左右子节点的大小关系
     * 没有考虑到 right.left.val > root 的情况，坑爹
     *
     * @param root
     * @param min 作为右子树的最小值
     * @param max 作为左子树的最大值
     * @return
     */
    private static Boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){
        if (root == null){
            return true;
        }

        //针对右子树(当前节点最小): 如果min存在的情况下，当前的值比他还小
        if (min != null && root.getValue() <= min.getValue()){
            return false;
        }
        //针对左子树(当前节点最大): 如果max存在的情况下，当前的值比他还大
        if (max != null && root.getValue() >= max.getValue()){
            return false;
        }
        //注意：左子树永远比root小，右子树永远比root大
        return isValidBST(root.getLeft(),min,root)
                && isValidBST(root.getRight(),root,max);

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
