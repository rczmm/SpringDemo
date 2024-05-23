package com.rczmm.demo.service;

import java.util.List;
import com.rczmm.demo.domain.User;

/**
 * 用户，存储用户信息Service接口
 * 
 * @author rczmm
 * @date 2024-05-13
 */
public interface IUserService 
{
    /**
     * 查询用户，存储用户信息
     * 
     * @param id 用户，存储用户信息主键
     * @return 用户，存储用户信息
     */
     User selectUserById(Long id);

    /**
     * 查询用户，存储用户信息列表
     * 
     * @param user 用户，存储用户信息
     * @return 用户，存储用户信息集合
     */
     List<User> selectUserList(User user, int page, int limit);

    /**
     * 新增用户，存储用户信息
     * 
     * @param user 用户，存储用户信息
     * @return 结果
     */
     int insertUser(User user);

    /**
     * 修改用户，存储用户信息
     * 
     * @param user 用户，存储用户信息
     * @return 结果
     */
     int updateUser(User user);

    /**
     * 批量删除用户，存储用户信息
     * 
     * @param ids 需要删除的用户，存储用户信息主键集合
     * @return 结果
     */
     int deleteUserByIds(Long[] ids);

    /**
     * 删除用户，存储用户信息信息
     * 
     * @param id 用户，存储用户信息主键
     * @return 结果
     */
     int deleteUserById(Long id);
}
