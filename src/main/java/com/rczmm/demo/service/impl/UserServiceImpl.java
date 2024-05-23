package com.rczmm.demo.service.impl;

import com.rczmm.demo.domain.User;
import com.rczmm.demo.mapper.UserMapper;
import com.rczmm.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户，存储用户信息Service业务层处理
 *
 * @author rczmm
 * @date 2024-05-13
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    /**
     * 查询用户，存储用户信息
     *
     * @param id 用户，存储用户信息主键
     * @return 用户，存储用户信息
     */
    @Override
    public User selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }

    /**
     * 查询用户，存储用户信息列表
     *
     * @param user 用户，存储用户信息
     * @return 用户，存储用户信息
     */
    @Cacheable(value = "user", key = "'userlist:'+ #user.toString()")
    @Override
    public List<User> selectUserList(User user) {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增用户，存储用户信息
     *
     * @param user 用户，存储用户信息
     * @return 结果
     */
    @Cacheable(value = "user", key = "#user.id")
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /**
     * 修改用户，存储用户信息
     *
     * @param user 用户，存储用户信息
     * @return 结果
     */
    @CachePut(value = "user", key = "#user.id")
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除用户，存储用户信息
     *
     * @param ids 需要删除的用户，存储用户信息主键
     * @return 结果
     */
    @CacheEvict(value = "user", allEntries = true)
    @Override
    public int deleteUserByIds(Long[] ids) {
        return userMapper.deleteUserByIds(ids);
    }

    /**
     * 删除用户，存储用户信息信息
     *
     * @param id 用户，存储用户信息主键
     * @return 结果
     */
    @CacheEvict(value = "user", key = "#id")
    @Override
    public int deleteUserById(Long id) {
        return userMapper.deleteUserById(id);
    }
}
