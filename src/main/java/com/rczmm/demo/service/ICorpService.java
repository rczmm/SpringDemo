package com.rczmm.demo.service;

import java.util.List;
import com.rczmm.demo.domain.Corp;

/**
 * 部门，存储部门信息Service接口
 * 
 * @author rczmm
 * @date 2024-05-13
 */
public interface ICorpService 
{
    /**
     * 查询部门，存储部门信息
     * 
     * @param id 部门，存储部门信息主键
     * @return 部门，存储部门信息
     */
     Corp selectCorpById(Long id);

    /**
     * 查询部门，存储部门信息列表
     * 
     * @param corp 部门，存储部门信息
     * @return 部门，存储部门信息集合
     */
     List<Corp> selectCorpList(Corp corp);

    /**
     * 新增部门，存储部门信息
     * 
     * @param corp 部门，存储部门信息
     * @return 结果
     */
     int insertCorp(Corp corp);

    /**
     * 修改部门，存储部门信息
     * 
     * @param corp 部门，存储部门信息
     * @return 结果
     */
     int updateCorp(Corp corp);

    /**
     * 批量删除部门，存储部门信息
     * 
     * @param ids 需要删除的部门，存储部门信息主键集合
     * @return 结果
     */
     int deleteCorpByIds(Long[] ids);

    /**
     * 删除部门，存储部门信息信息
     * 
     * @param id 部门，存储部门信息主键
     * @return 结果
     */
     int deleteCorpById(Long id);
}
