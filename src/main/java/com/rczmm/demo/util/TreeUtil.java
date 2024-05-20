package com.rczmm.demo.util;

import com.rczmm.demo.domain.Corp;
import com.rczmm.demo.domain.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 树工具类
 *
 * @author rczmm
 * @date 2020/12/16
 */
public class TreeUtil {

    /**
     * 构建树
     *
     * @param list 列表
     * @return 字典
     */
    public static Map<Long, TreeNode<Corp>> buildTree(List<Corp> list) {

        /*
          1. Check if the list is empty
          2. If the list is empty, return null
         */
        if (Objects.isNull(list) || list.isEmpty()) {
            return null;
        }

        /*
         * 1. Create a map to store all nodes
         * 2. Create a map to store the child nodes of each node
         * 3. Create a list to store the root nodes
         * 4. Create a map to store the root nodes
         */
        Map<Long, TreeNode<Corp>> allNodeMap = new HashMap<>();

        Map<Long, List<Corp>> childCorpMap = list.stream().collect(Collectors.groupingBy(Corp::getPid));
        List<Long> rootIds = new ArrayList<>();


        for (Corp corp : list) {
            TreeNode<Corp> treeNode = new TreeNode<>();
            treeNode.setData(corp);
            treeNode.setChildren(new ArrayList<>());


            allNodeMap.put(corp.getId(), treeNode);

            /*
             * If the parent id is the same as the id, it means that it is a root node
             */
            if (corp.getPid().equals(corp.getId())) {
                rootIds.add(corp.getId());
            }
        }

        /*
         * 1. Iterate over all nodes
         * 2. For each node, find its children nodes and add them to the children list of the current node
         */
        for (Map.Entry<Long, TreeNode<Corp>> entry : allNodeMap.entrySet()) {
            TreeNode<Corp> currentNode = entry.getValue();
            List<Corp> chilCorpList = childCorpMap.get(entry.getKey());
            if (Objects.nonNull(chilCorpList)) {
                for (Corp corp : chilCorpList) {
                    // Skip if the child node is a root node itself
                    if (rootIds.contains(corp.getId())) {
                        continue;
                    }
                    TreeNode<Corp> childNode = allNodeMap.get(corp.getId());
                    currentNode.getChildren().add(childNode);
                }
            }
        }

        /*
         * 1. Create a map to store the root nodes
         * 2. Iterate over the root ids
         * 3. For each root id, get the corresponding node from the all node map and add it to the root node map
         */
        Map<Long, TreeNode<Corp>> rootTree = new HashMap<>();
        for (Long rootId : rootIds) {
            rootTree.put(rootId, allNodeMap.get(rootId));
        }

        return rootTree;
    }


}
