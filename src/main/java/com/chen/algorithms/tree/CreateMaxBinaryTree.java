package com.chen.algorithms.tree;

import java.util.Arrays;

/**
 * 构建最大二叉树-654
 * 给定一个数组，根为数组最大值
 * 左右子树是数组中最大值左右两边部分所构建出来的最大二叉树（递归）
 *
 * @author Redamancy
 * @date 2022/3/22 - 21:13
 */
public class CreateMaxBinaryTree {
    public static void main(String[] args) {
        int[] tree = new int[]{3,2,1,6,0,5,8};
        TreeNode root = createTree(tree);
        System.out.println(root);
    }

    private static TreeNode createTree(int[] nums){

        //找到数据中最大值及下标，将数组切割成两部分依次递归构建
        if (nums.length == 0){
            return null;
        }
        int maxElement = Integer.MIN_VALUE;
        int index = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] > maxElement){
                maxElement = nums[i];
                index = i;
            }
        }

        //构建树
        TreeNode root = new TreeNode();
        root.setValue(maxElement);
        //递归构建左右子树
        int[] left = Arrays.copyOfRange(nums,0,index);
        int[] right = Arrays.copyOfRange(nums,index+1,nums.length);
        root.setLeft(createTree(left));
        root.setRight(createTree(right));

        return root;
    }
}
