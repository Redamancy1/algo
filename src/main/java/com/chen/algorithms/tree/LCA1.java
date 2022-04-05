package com.chen.algorithms.tree;


/**
 * 寻找最近公共祖先节点 - 236
 * 只有一个值存在也可以返回
 * 都不存在才返回null
 *
 * @author Redamancy
 * @date 2022/3/30 - 20:54
 */
public class LCA1 {

    public static void main(String[] args) {
        TreeNode root = getRoot();
        TreeNode ancestorNode = getAncestorNode(root,1,6);
        System.out.println("最近的公共祖先节点："+ancestorNode);
    }

    /**
     * 若当前节点是p/q,返回root
     * 若当前节点 left,right 都符合，返回root
     * 若 left,right 都不符合，返回null
     * 若 left,right 只有一个符合，返回 left/right
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode getAncestorNode(TreeNode root,int p,int q){
        if (root == null){
            return null;
        }
        // 这个判断要具体看题意
        // 只有当题目说明就算只找到一个也可以返回的时候，这个判断才能放在前序遍历的位置
        // 因为有的题目如果只存在一个值而不是两个值都存在的话就不能算LCA,返回null -> LCA2
        // 也就是说这个判断代码要放在后序遍历的位置，相当于全部节点都要遍历
        // 这里放在这里是因为至少有一个都算符合可以直接返回
        if (root.getValue() == p || root.getValue() == q){
            return root;
        }

        TreeNode left = getAncestorNode(root.getLeft(),p,q);
        TreeNode right = getAncestorNode(root.getRight(),p,q);
        //情况1：如果p,q都在root根节点的树中
        if (left != null && right != null) {
            return root;
        }
        //情况2：p,q都不在root根节点的树中
        if (left == null && right == null) {
            return null;
        }
        //情况3：p,q只有一个在root根节点的树中
        return left == null ? right : left;


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
