package com.rczmm.demo.domain;

import java.util.List;


/**
 * 树节点
 *
 * @param <T>
 * @author rczmm
 * @date 2024/05/20 14:14
 */
public class TreeNode<T> extends BaseDO {

    /**
     * 数据
     */
    private T data;

    /**
     * 子节点
     */
    private List<TreeNode<T>> children;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }
}

