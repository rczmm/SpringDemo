package com.rczmm.demo.service.impl;

import com.rczmm.demo.domain.Corp;
import com.rczmm.demo.domain.TreeNode;
import com.rczmm.demo.mapper.CorpMapper;
import com.rczmm.demo.service.ICorpService;
import com.rczmm.demo.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 部门，存储部门信息Service业务层处理
 *
 * @author rczmm
 * @date 2024-05-13
 */
@Slf4j
@Service
public class CorpServiceImpl implements ICorpService {

    private final CorpMapper corpMapper;

    @Autowired
    public CorpServiceImpl(CorpMapper corpMapper) {
        this.corpMapper = corpMapper;
    }


    /**
     * 查询部门，存储部门信息
     *
     * @param id 部门，存储部门信息主键
     * @return 部门，存储部门信息
     */
    @Cacheable(cacheNames = "corp", key = "#id")
    @Override
    public Corp selectCorpById(Long id) {
        return corpMapper.selectCorpById(id);
    }

    /**
     * 查询部门，存储部门信息列表
     *
     * @param corp 部门，存储部门信息
     * @return 部门，存储部门信息
     */
    @Cacheable(cacheNames = "corp", key = "'selectCorpList:' + #corp.toString()")
    @Override
    public Map<Long, TreeNode<Corp>> selectCorpList(Corp corp) {
        List<Corp> corpList = corpMapper.selectCorpList(corp);
        return TreeUtil.buildTree(corpList);
    }

    /**
     * 新增部门，存储部门信息
     *
     * @param corp 部门，存储部门信息
     * @return 结果
     */
    @CachePut(cacheNames = "corp", key = "#corp.id")
    @Override
    public int insertCorp(Corp corp) {
        return corpMapper.insertCorp(corp);
    }

    /**
     * 修改部门，存储部门信息
     *
     * @param corp 部门，存储部门信息
     * @return 结果
     */
    @CachePut(cacheNames = "corp", key = "#corp.id")
    @Override
    public int updateCorp(Corp corp) {
        return corpMapper.updateCorp(corp);
    }

    /**
     * 批量删除部门，存储部门信息
     *
     * @param ids 需要删除的部门，存储部门信息主键
     * @return 结果
     */
    @CacheEvict(cacheNames = "corp", allEntries = true)
    @Override
    public int deleteCorpByIds(Long[] ids) {
        return corpMapper.deleteCorpByIds(ids);
    }

    /**
     * 删除部门，存储部门信息信息
     *
     * @param id 部门，存储部门信息主键
     * @return 结果
     */
    @CacheEvict(cacheNames = "corp", key = "#id")
    @Override
    public int deleteCorpById(Long id) {
        return corpMapper.deleteCorpById(id);
    }
}
