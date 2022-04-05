package com.chen.algorithms.tree;

/**
 * 通过前序与中序遍历结果构造二叉树-105
 * 思路：
 * 前序第一个就是root，得知root后中序root值左右两部分就是左右子树
 *
 * @author Redamancy
 * @date 2022/3/23 - 21:00
 */
public class CreateTreeByPreAndMidSort {
    public static void main(String[] args) {
        //提供树前序遍历与中序表遍历的结果
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] midOrder = new int[]{9,3,15,20,7};
        TreeNode root = buildTree(preOrder,midOrder);
        System.out.println(root);

    }

    private static TreeNode buildTree(int[] preOrder,int[] midOrder){
        return build(preOrder,0,preOrder.length-1,
                midOrder,0,midOrder.length-1);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd,
                                  int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        //中序遍历后左子树的节点个数（index差）
        //即在前序遍历中，左子树的最后一个的下标是  preStart+leftSize（preStart为root下标)
        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode();
        root.setValue(rootVal);
        // 递归构造左右子树
        TreeNode left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        TreeNode right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        root.setLeft(left);
        root.setRight(right);
        return root;
    }

}
