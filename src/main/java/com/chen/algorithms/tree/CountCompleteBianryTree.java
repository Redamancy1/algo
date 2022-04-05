package com.chen.algorithms.tree;

/**
 * 计算完全二叉树节点数
 * 如何通过技巧降低程序的时间复杂度
 *
 * @author Redamancy
 * @date 2022/3/30 - 21:11
 */
public class CountCompleteBianryTree {

    public static void main(String[] args) {
        TreeNode root = getRoot();
        int num = countNodes(root);
        System.out.println("当前完全二叉树的节点总数量为："+num);
    }

    /**
     * 首先完全二叉树与满二叉树的区别在于
     * 满二叉树的每一层节点都是满的
     * 完全二叉树每一层不一定是满的，但最后一层节点肯定集中于左侧
     * 也就是说满二叉树是一种特殊的完全二叉树
     * 满二叉树节点数计算方式：2^h - 1 （h 为树的高度）
     *
     * @param root
     * @return
     */
    private static int countNodes(TreeNode root){
        TreeNode l = root,r = root;
        //记录左右子树的高度
        int hl = 0 , hr = 0;
        while (l != null) {
            l = l.getLeft();
            hl++;
        }
        while (r != null) {
            r = r.getRight();
            hr++;
        }
        //如果左右子树的高度相等，那么这个完全二叉树是一颗满二叉树
        //就可以直接根据公式 计算得到该树的节点总数，不需要再去递归
        if (hl == hr){
            return (int)Math.pow(2,hl) - 1;
        }

        //否则继续按普通二叉树的逻辑计算节点数量
        return 1+countNodes(root.getLeft())+countNodes(root.getRight());
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
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        rootLeft.setLeft(leftLeft);
        rootLeft.setRight(leftRight);
        return root;
    }
}
