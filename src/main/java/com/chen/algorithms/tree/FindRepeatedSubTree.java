package com.chen.algorithms.tree;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 寻找二叉树中的重复子树-652
 *
 * @author Redamancy
 * @date 2022/3/22 - 20:45
 */
public class FindRepeatedSubTree {

    /**
     * 记录所有子树出现的次数
     * @param args
     */
    private static HashMap<String,Integer> subTreeMap = new HashMap<>();

    /**
     * 记录重复的子树-根节点
     * @param args
     */
    private static LinkedList<TreeNode> res = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = getRoot();
        traverse(root);
        System.out.println(res);

    }

    /**
     * 将树序列化成字符串保存，方便用来比较是否出现过相同的子树
     *
     * @param root
     * @return
     */
    private static String traverse(TreeNode root){
        //填充空节点信息
        if (root == null){
            return "#";
        }

        //递归获取左右子树‘字符串’
        String left = traverse(root.getLeft());
        String right = traverse(root.getRight());

        //拼接当前根节点“树文字”
        String subTreeChar = left + "," + right + "," + root.getValue();

        //检查当前“树文字”在子树map中出现的次数
        int times = subTreeMap.getOrDefault(subTreeChar,0);
        //如果次数为1，说明已有重复的子树，将当前根节点信息保存（不会重复只保存一次）
        if (times == 1){
            res.add(root);
        }
        //每次将当前子树信息保存，次数+1  key-value
        subTreeMap.put(subTreeChar,times+1);

        return subTreeChar;
    }

    private static TreeNode getRoot(){
        TreeNode root = new TreeNode();
        root.setValue(3);
        TreeNode left = new TreeNode();
        left.setValue(4);
        TreeNode right = new TreeNode();
        right.setValue(5);
        TreeNode leftLeft = new TreeNode();
        leftLeft.setValue(8);
        TreeNode rightLeft = new TreeNode();
        rightLeft.setValue(4);
        TreeNode rightRight = new TreeNode();
        rightRight.setValue(8);
        TreeNode right2Left = new TreeNode();
        right2Left.setValue(8);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        rightLeft.setLeft(right2Left);
        return root;
    }
}
