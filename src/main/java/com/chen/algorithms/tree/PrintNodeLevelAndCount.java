package com.chen.algorithms.tree;

/**
 * test
 *
 * @author Redamancy
 * @date 2022/3/11 - 21:12
 */
public class PrintNodeLevelAndCount {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode rootLeft = new TreeNode();
        TreeNode rootRight = new TreeNode();
        TreeNode leftLeft = new TreeNode();
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        rootLeft.setLeft(leftLeft);
        root.setValue(1);rootLeft.setValue(2);rootRight.setValue(3);leftLeft.setValue(4);
        //root为第一层，打印每个节点所在层数
        printLevel(root,1);
        //打印每个节点左右子树有多少节点
        countNode(root);
    }

    /**
     * 前序位置的代码只能从函数参数中获取父节点传递来的数据
     * 而后序位置的代码不仅可以获取参数数据，还可以获取到子树通过函数返回值传递回来的数据
     * 只有后序位置才能通过返回值获取子树的信息
     *
     * 一旦发现题目和子树有关，那大概率要给函数设置合理的定义和返回值，在后序位置写代码了
     *
     * @param root
     * @param level
     */
    private static void printLevel(TreeNode root,int level){
        if (root == null){
            return;
        }
        //前序位置
        System.out.println("节点【"+root.getValue()+"】在第"+level+"层");
        printLevel(root.getLeft(),level+1);
        printLevel(root.getRight(),level+1);
    }

    private static int countNode(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftCount = countNode(root.getLeft());
        int rightCount = countNode(root.getRight());
        //后序位置
        System.out.println("节点【"+root.getValue()+"】左子树有"+leftCount+"个节点，右子树有"+rightCount+"个节点");

        //父节点左右子树节点数分别为【子节点的左右子树节点数+1（本身）】
        return leftCount + rightCount +1;
    }
}
