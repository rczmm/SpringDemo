package com.rczmm.demo.domain;

import lombok.Data;

import java.util.List;


/**
 * 树节点
 *
 * @param <T>
 */
@Data
public class TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children;

}

