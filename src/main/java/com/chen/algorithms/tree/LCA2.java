package com.chen.algorithms.tree;


/**
 * 寻找最近公共祖先节点 - 1644
 * ！只有当两个值都存在时才符合条件
 * 否则返回null
 *
 * @author Redamancy
 * @date 2022/3/31 - 21:23
 */
public class LCA2 {

    private static boolean foundP = false,foundQ = false;

    public static void main(String[] args) {
        TreeNode root = getRoot();
        TreeNode ancestorNode = find(root,2,7);
        System.out.println("最近的公共祖先节点："+ancestorNode);

    }

    private static TreeNode find(TreeNode root,int p,int q){
        TreeNode res = getAncestorNode(root,p,q);
        //两个有其中一个不存在就返回null
        if (!foundQ || !foundP) {
            return null;
        }
        //p,q都在二叉树里才有公共祖先
        return res;
    }

    private static TreeNode getAncestorNode(TreeNode root,int p,int q){
        if (root == null){
            return null;
        }

        //前序

        TreeNode left = getAncestorNode(root.getLeft(),p,q);
        TreeNode right = getAncestorNode(root.getRight(),p,q);

        //放在后序位置是因为需要遍历所有节点，看看是不是两个值都存在
        //而不是直接在前序位置 if (root.getValue() == p || root.getValue() == q) return root
        if (left !=null && right != null){
            return root;
        }

        if (root.getValue() == p || root.getValue() == q) {
            //记录哪个值找到了
            if (root.getValue() == p) {
                foundP = true;
            }
            if (root.getValue() == q) {
                foundQ = true;
            }
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
