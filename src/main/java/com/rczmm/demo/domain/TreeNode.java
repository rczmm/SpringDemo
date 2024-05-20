package com.rczmm.demo.domain;

import lombok.Data;

import java.util.List;


/**
 * 树节点
 *
 * @param <T>
 * @author rczmm
 * @date 2024/05/20 14:14
 */
@Data
public class TreeNode<T> extends BaseDO {
    private T data;
    private List<TreeNode<T>> children;

}

