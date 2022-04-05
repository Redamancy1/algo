package com.chen.algorithms.tree;

/**
 * BST中插入、删除一个数
 *
 * @author Redamancy
 * @date 2022/3/24 - 20:39
 */
public class BSTInsertAndDeleteNode {

    public static void main(String[] args) {
        TreeNode root = getRoot();
        int NodeVal = 7;
        int val = 3;
        insertNode(root,NodeVal);
        System.out.println(root);
        //注意
        deleteNode(root,val);
        System.out.println(root);

    }

    private static TreeNode insertNode(TreeNode root,int val){
        if (root == null){
            TreeNode node = new TreeNode();
            node.setValue(val);
            return node;
        }

        if (root.getValue() == val){
            System.out.println("插入失败！插入的值已存在，不符合BST性质");
            return null;
        }
        //插入值比当前节点大，将其插到右子树
        if (root.getValue() < val) {
            root.setRight(insertNode(root.getRight(),val));
        }
        //插入值比当前节点小，将其插到左子树
        if (root.getValue() > val){
            root.setLeft(insertNode(root.getLeft(),val));
        }

        return root;
    }

    /**
     * 1.要删除的节点无子节点-->当场去世，删除它
     * 2.要删除的节点存在一个子节点-->让其子节点替代它的位置
     * 3.要删除的节点存在两个子节点(不能破坏BST性质)
     *  3.1 找出左子树最大的子节点替代自己
     *  3.2 找出右子树最大的子节点替代自己
     *
     * @param root
     * @param val
     * @return
     */
    private static TreeNode deleteNode(TreeNode root,int val){
        if (root == null){
            return null;
        }
       //如果当前节点是要删除的，就要返回一个值给父节点去重新设置子节点
        if (root.getValue() == val){
            //1,2
            if (root.getLeft() == null){
                return root.getRight();
            }
            if (root.getRight() == null){
                return root.getLeft();
            }
            //3
            //获取右子树最小节点
            TreeNode minNode = getMin(root.getRight());
            //删除右子树最小节点
            root.setRight(deleteNode(root.getRight(), minNode.getValue()));
            //将右子树最小节点替代要删除的节点-设置同款子树信息
            minNode.setLeft(root.getLeft());
            minNode.setRight(root.getRight());
            //替代被删除的节点
            root = minNode;
        }else if (root.getValue() > val){
            root.setLeft(deleteNode(root.getLeft(),val));
        }else if (root.getValue() < val){
            root.setRight(deleteNode(root.getRight(),val));
        }
        return root;
    }

    //获取最小节点
    private static TreeNode getMin(TreeNode node){
        while (node.getLeft() != null){
            //BST最左边的最小
            node = node.getLeft();
        }
        return node;
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
