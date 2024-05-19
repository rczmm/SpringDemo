package com.rczmm.demo.service.impl;

import java.util.List;

import com.rczmm.demo.mapper.UserMapper;
import com.rczmm.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rczmm.demo.domain.User;

/**
 * 用户，存储用户信息Service业务层处理
 * 
 * @author rczmm
 * @date 2024-05-13
 */
@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户，存储用户信息
     * 
     * @param id 用户，存储用户信息主键
     * @return 用户，存储用户信息
     */
    @Override
    public User selectUserById(Long id)
    {
        return userMapper.selectUserById(id);
    }

    /**
     * 查询用户，存储用户信息列表
     * 
     * @param user 用户，存储用户信息
     * @return 用户，存储用户信息
     */
    @Override
    public List<User> selectUserList(User user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增用户，存储用户信息
     * 
     * @param user 用户，存储用户信息
     * @return 结果
     */
    @Override
    public int insertUser(User user)
    {
        return userMapper.insertUser(user);
    }

    /**
     * 修改用户，存储用户信息
     * 
     * @param user 用户，存储用户信息
     * @return 结果
     */
    @Override
    public int updateUser(User user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除用户，存储用户信息
     * 
     * @param ids 需要删除的用户，存储用户信息主键
     * @return 结果
     */
    @Override
    public int deleteUserByIds(Long[] ids)
    {
        return userMapper.deleteUserByIds(ids);
    }

    /**
     * 删除用户，存储用户信息信息
     * 
     * @param id 用户，存储用户信息主键
     * @return 结果
     */
    @Override
    public int deleteUserById(Long id)
    {
        return userMapper.deleteUserById(id);
    }
}
