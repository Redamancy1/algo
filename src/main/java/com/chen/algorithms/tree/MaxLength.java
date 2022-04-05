package com.chen.algorithms.tree;

/**
 * 计算树种任意两个节点之间最长直径
 *
 * @author Redamancy
 * @date 2022/3/12 - 21:24
 */
public class MaxLength {

    /**
     * 记录树中任意两个节点之间的最长直径
     */
    private static int maxLength = 0;

    public static void main(String[] args) {
        //暂不写数据，大概思路
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        TreeNode leftLeft = new TreeNode();
        TreeNode leftRight = new TreeNode();
        TreeNode rightRight = new TreeNode();
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setRight(rightRight);
        int maxLength = getMaxLenth(root);
        System.out.println("最长："+maxLength);
    }

    private static int getMaxLenth(TreeNode root){
        //计算每个节点直径
        traverse(root);
        return maxLength;
    }

    /**
     *     遍历
     */
    private static void traverse(TreeNode root){
        if (root == null){
            return;
        }
        //对每个节点的左右直径进行计算
        int leftMax = maxDepth(root.getLeft());
        int rightMax = maxDepth(root.getRight());
        int nowLength = leftMax + rightMax;
        //比较最大直径
        maxLength = Math.max(nowLength,maxLength);

        traverse(root.getLeft());
        traverse(root.getRight());

    }

    private static int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftMax = maxDepth(root.getLeft());
        int rightMax = maxDepth(root.getRight());
        return 1+Math.max(leftMax,rightMax);
    }
}
