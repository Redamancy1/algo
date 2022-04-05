package com.chen.algorithms.tree;

import sun.reflect.generics.tree.Tree;

import java.util.HashSet;

/**
 * 寻找多个节点的最近公共祖先节点 - 1676
 * 多个节点，需要HashSet记录，判断是否已存在
 *
 * @author Redamancy
 * @date 2022/3/31 - 21:48
 */
public class LCA3 {

    public static void main(String[] args) {
        TreeNode root = getRoot();
        int[] targets = new int[]{2,3,6};
        TreeNode ancestorNode = getAncestorNode(root,targets);
        System.out.println("最近的公共祖先节点："+ancestorNode);
    }

    private static TreeNode getAncestorNode(TreeNode root,int[] nums){
        //将列表转化为哈希集合，便于判断元素是否存在
        HashSet<Integer> values = new HashSet<>();
        for (Integer a : nums){
            values.add(a);
        }
        return find(root,values);
    }

    private static TreeNode find(TreeNode root,HashSet<Integer> values){
        if (root == null){
            return null;
        }
        //前序位置-说明不用全部值都存在也行
        if(values.contains(root.getValue())){
            return root;
        }

        TreeNode left = find(root.getLeft(),values);
        TreeNode right = find(root.getRight(),values);

        if (left != null && right != null) {
            return root;
        }

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
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        rootLeft.setLeft(leftLeft);
        rootLeft.setRight(leftRight);

        return root;
    }
}
