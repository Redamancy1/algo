package com.chen.algorithms.tree;

/**
 * 小例子
 * 只写大概思路
 *
 * @author Redamancy
 * @date 2022/3/12 - 21:05
 */
public class MaxDepth {

    //最大深度
    private static int result = 0;
    //当前遍历到的节点深度
    private static int depth = 0;

    public static void main(String[] args) {
        //暂不写数据，大概思路
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        TreeNode leftRihgt = new TreeNode();
        root.setLeft(left);
        root.setRight(right);
        left.setRight(leftRihgt);
        int result = getMaxDepth(root);
        System.out.println("最大深度为："+result);
        System.out.println(maxDepth(root));
    }

    /**
     * 获取树最大深度
     * @return
     */
    private static int getMaxDepth(TreeNode root){
        traverse(root);
        return result;
    }

    private static void traverse(TreeNode root){
       if (root == null){
           result = Math.max(result,depth);
           return;
       }
       //这里以根节点为1开始
       //每到一层新的，深度++
       depth++;
       traverse(root.getLeft());
       traverse(root.getRight());
       //本层遍历完返回上一层，深度--
       depth--;
    }

    private static int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()))+1;
    }
}
