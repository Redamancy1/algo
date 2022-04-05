package com.chen.algorithms.tree;

/**
 * 二叉搜索子树的最大键值和 - 1373
 * 给定一颗二叉树，找到二叉树中的二叉搜索树-子树
 * 并返回所有二叉搜索子树中【键值和】最大的值
 *
 * @author Redamancy
 * @date 2022/3/30 - 20:56
 */
public class BSTMaxValSum {

    private static int maxSum = 0;

    public static void main(String[] args) {
        TreeNode root = getRoot();
        maxSumBst(root);
        System.out.println("最大和为："+maxSum);

    }

    /**
     *
     * @param root
     * @return
     */
    private static int maxSumBst(TreeNode root){
        traverse(root);
        return maxSum;
    }

    /**
     * 使用后序遍历，可以避免在递归中使用其他递归
     * 什么时候用后序？栗子
     *
     * 计算root为根的二叉树节点之和：可以通过左右子树的和加上 root.value；
     * 计算root为根的二叉树的max/min：可以通过左右子树的 max/min 跟 root.value 比较；
     * 判断root为根的二叉树是不是 BST：可以通过判断左右子树是不是 BST，再看左右子树的最大值最小值与 root.value 比较
     *
     * @param root
     * @return
     */
    private static int[] traverse(TreeNode root){
        if (root == null){
            //int[]{以root为根的二叉树是否是BST,该树的节点最小值，该树的节点最大值，该树的节点值之和}
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }

        //递归计算左右子树
        int[] left = traverse(root.getLeft());
        int[] right = traverse(root.getRight());

        /*********后序遍历*********/
        // 通过 left 和 right 推导返回值,并且正确更新 maxSum 变量
        int[] res = new int[4];
        //判断 root 为根的二叉树是不是 BST
        if (left[0] == 1 && right[0] == 1 && root.getValue() > left[2] && root.getValue() < right[1]){
            //符合条件，开始构建
            //与前序遍历最大区别就是在这里就把把需要的值都准备好了，不需要再去递归上加递归
            res[0] = 1;
            res[1] = Math.min(left[1],root.getValue() );
            res[2] = Math.max(right[2],root.getValue());
            res[3] = left[3] + right[3] + root.getValue();

            maxSum = Math.max(maxSum,res[3]);
        }else {
            res[0] = 0;
        }
        /************************/

        return res;
    }

    /**
     *  1、左右子树是否是 BST。
     *  2、左子树的最大值和右子树的最小值。
     *  3、左右子树的节点值之和。
     * 用前序遍历的方式递归，以上三个值需要额外计算，如果用后序遍历就可以在遍历的时候顺便返回
     * @param root
     */
    private static void preTraberse(TreeNode root){

        //如果使用前序遍历的方式-嵌套了多层递归
        if (root ==  null) {
            return;
        }

        /******* 前序遍历位置 *******/
        // 判断左右子树是不是 BST
        if (!isBST(root.getLeft()) || !isBST(root.getRight())) {
        //TODO
        }
        // 计算左子树的最大值和右子树的最小值
        int leftMax = findMax(root.getLeft());
        int rightMin = findMin(root.getRight());
        // 判断以 root 节点为根的树是不是 BST
        if (root.getValue() <= leftMax || root.getValue() >= rightMin) {
        //TODO
        }
        // 如果条件都符合，计算当前 BST 的节点之和
        int leftSum = findSum(root.getLeft());
        int rightSum = findSum(root.getRight());
        int rootSum = leftSum + rightSum + root.getValue();
        // 计算 BST 节点的最大和
        maxSum = Math.max(maxSum, rootSum);
        /**************************/

        // 递归左右子树
        preTraberse(root.getLeft());
        preTraberse(root.getRight());
    }

    /**
     * 这四个辅助函数都是递归函数，主函数也是递归函数
     * 也就是递归中加递归，太不行了
     * @param left
     * @return
     */
    private static int findSum(TreeNode left) {
        return 1;
    }
    private static int findMin(TreeNode right) {
        return 2;
    }
    private static int findMax(TreeNode left) {
        return 1;
    }
    private static boolean isBST(TreeNode left) {
        return true;
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
