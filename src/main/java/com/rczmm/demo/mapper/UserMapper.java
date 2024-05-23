package com.rczmm.demo.mapper;

import com.rczmm.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户，存储用户信息Mapper接口
 *
 * @author rczmm
 * @date 2024-05-13
 */
@Mapper
public interface UserMapper {
    /**
     * 查询用户，存储用户信息
     *
     * @param id 用户，存储用户信息主键
     * @return 用户，存储用户信息
     */
    User selectUserById(@Param("id") Long id);

    /**
     * 查询用户，存储用户信息列表
     *
     * @param user 用户，存储用户信息
     * @return 用户，存储用户信息集合
     */
    List<User> selectUserList(@Param("user") User user);

    /**
     * 新增用户，存储用户信息
     *
     * @param user 用户，存储用户信息
     * @return 结果
     */
    int insertUser(@Param("user") User user);

    /**
     * 修改用户，存储用户信息
     *
     * @param user 用户，存储用户信息
     * @return 结果
     */
    int updateUser(@Param("user") User user);

    /**
     * 删除用户，存储用户信息
     *
     * @param id 用户，存储用户信息主键
     * @return 结果
     */
    int deleteUserById(@Param("id") Long id);

    /**
     * 批量删除用户，存储用户信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteUserByIds(@Param("ids") Long[] ids);
}
