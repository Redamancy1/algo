package com.chen.algorithms.tree;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 共用树节点类
 *
 * @author Redamancy
 * @date 2022/3/11 - 20:18
 */
@Data
@Getter
@Setter
public class TreeNode {
    /**
     * 当前树节点值
     */
    private int value;
    /**
     * 左节点
     */
    private TreeNode left;
    /**
     * 右节点
     */
    private TreeNode right;
    /**
     * 所指向右侧指针
     */
    private TreeNode next;
}
