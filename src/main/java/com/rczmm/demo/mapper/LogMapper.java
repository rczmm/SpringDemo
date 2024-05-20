package com.rczmm.demo.mapper;

import com.rczmm.demo.domain.Log;

/**
 * 日志，存储日志信息Mapper接口
 *
 * @author rczmm
 * @date 2020/12/14
 */
public interface LogMapper {

    /**
     * 查询日志，存储日志信息
     *
     * @param id id
     * @return Log
     */
    Log selectLogById(Integer id);


    /**
     * 插入日志
     *
     * @param log 日志
     * @return 结果
     */
    int insertLog(Log log);


    /**
     * 更新日志
     *
     * @param log 日志
     * @return 结果
     */
    int updateLog(Log log);


    /**
     * 删除日志
     *
     * @param id id
     * @return 结果
     */
    int deleteLogById(Integer id);
}
