package com.chen.algorithms.tree;

/**
 * 二叉搜索树的最近公共祖先节点 - 235
 * 根据左小右大性质，可以有效减小递归
 *
 * @author Redamancy
 * @date 2022/3/31 - 22:28
 */
public class LCABST {

    public static void main(String[] args) {
        TreeNode root = getRoot();
        TreeNode ancestorNode = getAncestorNode(root,6,4);
        System.out.println("最近的公共祖先节点："+ancestorNode);
    }

    /**
     * min < max，min <= root.value <= max则说明当前节点就是LCA；
     * 若root.value < min，则需要去值更大的右子树寻找LCA；
     * 若root.value > max，则需要去值更小的左子树寻找LCA
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode getAncestorNode(TreeNode root,int p,int q){
        int min = Math.min(p,q);
        int max = Math.max(p,q);
        return find(root,min,max);
    }

    private static TreeNode find(TreeNode root,int min,int max){
        if (root == null) {
            return null;
        }
        //大了，去左子树
        if (root.getValue() > max) {
            return find(root.getLeft(),min,max);
        }
        //小了，去右子树
        if (root.getValue() < min) {
            return find(root.getRight(),min,max);
        }
        //后序
        //min <= root.value <= max
        return root;
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
