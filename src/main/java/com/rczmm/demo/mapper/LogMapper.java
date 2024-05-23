package com.rczmm.demo.mapper;

import com.rczmm.demo.domain.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 日志，存储日志信息Mapper接口
 *
 * @author rczmm
 * @date 2024/05/14
 */
@Mapper
public interface LogMapper {

    /**
     * 查询日志，存储日志信息
     *
     * @param id id
     * @return Log
     */
    Log selectLogById(@Param("id") Integer id);


    /**
     * 插入日志
     *
     * @param log 日志
     * @return 结果
     */
    int insertLog(@Param("log") Log log);


    /**
     * 更新日志
     *
     * @param log 日志
     * @return 结果
     */
    int updateLog(@Param("log") Log log);


    /**
     * 删除日志
     *
     * @param id id
     * @return 结果
     */
    int deleteLogById(@Param("id") Integer id);
}
