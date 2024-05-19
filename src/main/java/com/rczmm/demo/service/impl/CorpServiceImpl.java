package com.rczmm.demo.service.impl;

import com.rczmm.demo.mapper.CorpMapper;
import com.rczmm.demo.service.ICorpService;
import com.rczmm.demo.domain.Corp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门，存储部门信息Service业务层处理
 *
 * @author rczmm
 * @date 2024-05-13
 */
@Service
public class CorpServiceImpl implements ICorpService {
    @Autowired
    private CorpMapper corpMapper;

    /**
     * 查询部门，存储部门信息
     *
     * @param id 部门，存储部门信息主键
     * @return 部门，存储部门信息
     */
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
    @Override
    public List<Corp> selectCorpList(Corp corp) {
        return corpMapper.selectCorpList(corp);
    }

    /**
     * 新增部门，存储部门信息
     *
     * @param corp 部门，存储部门信息
     * @return 结果
     */
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
    @Override
    public int deleteCorpById(Long id) {
        return corpMapper.deleteCorpById(id);
    }
}
