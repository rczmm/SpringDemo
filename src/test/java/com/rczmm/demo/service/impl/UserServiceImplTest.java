package com.rczmm.demo.service.impl;

import com.rczmm.demo.domain.User;
import com.rczmm.demo.mapper.UserMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 1. @ExtendWith(MockitoExtension.class) 指定扩展类
 *
 * @author rczmm
 * @date 2024/05/20
 */
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    /**
     * 1. @Mock: 模拟对象
     */
    @Mock
    private UserMapper userMapper;

    /**
     * 1. @InjectMocks: 注入模拟对象
     */
    @InjectMocks
    private UserServiceImpl userService;

    /**
     * 1. @BeforeEach: 每个测试方法执行前执行
     */
    @BeforeEach
    void setUp() {
        System.out.println("开始测试");
        userService = new UserServiceImpl(userMapper);
    }

    /**
     * 1. @AfterEach: 每个测试方法执行后执行
     */
    @AfterEach
    void tearDown() {
        System.out.println("测试结束");
        userService = null;
    }

    /**
     * 1. @Transactional(readOnly = true): 只读事务
     * 2. @Test: 测试方法
     * 3. verify: 验证方法是否被调用
     * 4. when: 模拟方法返回值
     * 5. Assertions.assertEquals: 断言
     */
    @Transactional(readOnly = true)
    @Test
    void selectUserById() {
        long id = 1;
        userService.selectUserById(id);
        verify(userMapper).selectUserById(id);
    }

    /**
     * 1. @Transactional(readOnly = true): 只读事务
     * 2. @Test: 测试方法
     * 3. verify: 验证方法是否被调用
     * 4. when: 模拟方法返回值
     * 5. Assertions.assertEquals: 断言
     */
    @Transactional(readOnly = true)
    @Test
    void selectUserList() {
        User user = new User();
        userService.selectUserList(user);
        verify(userMapper).selectUserList(user);
    }

    /**
     * 1. @Transactional: 事务
     * 2. @Rollback: 回滚
     * 3. @Test: 测试方法
     * 4. verify: 验证方法是否被调用
     * 5. when: 模拟方法返回值
     * 6. Assertions.assertEquals: 断言
     */
    @Transactional
    @Rollback
    @Test
    void insertUser() {
        User user = new User();
        user.setId(1L);
        user.setCorpId(1L);
        user.setName("data");
        user.setAccount("data");
        user.setCreateTime("2020-01-01 00:00:00");
        user.setUpdateTime("2020-01-01 00:00:00");
        when(userMapper.insertUser(user)).thenReturn(1);
        int result = userService.insertUser(user);
        verify(userMapper).insertUser(user);
        Assertions.assertEquals(1, result);
    }

    /**
     * 1. @Transactional: 事务
     * 2. @Rollback: 回滚
     * 3. @Test: 测试方法
     * 4. verify: 验证方法是否被调用
     * 5. when: 模拟方法返回值
     * 6. Assertions.assertEquals: 断言
     */
    @Transactional
    @Rollback
    @Test
    void updateUser() {
        User user = new User();
        user.setId(1L);
        user.setCorpId(1L);
        user.setName("data");
        user.setAccount("data");
        user.setCreateTime("2020-01-01 00:00:00");
        user.setUpdateTime("2020-01-01 00:00:00");
        when(userMapper.updateUser(user)).thenReturn(1);
        int result = userService.updateUser(user);
        verify(userMapper).updateUser(user);
        Assertions.assertEquals(1, result);
    }

    /**
     * 1. @Transactional: 事务
     * 2. @Rollback: 回滚
     * 3. @Test: 测试方法
     * 4. verify: 验证方法是否被调用
     * 5. when: 模拟方法返回值
     * 6. Assertions.assertEquals: 断言
     */
    @Transactional
    @Rollback
    @Test
    void deleteUserByIds() {
        Long[] ids = {1L, 2L, 3L};
        when(userMapper.deleteUserByIds(ids)).thenReturn(1);
        int result = userService.deleteUserByIds(ids);
        verify(userMapper).deleteUserByIds(ids);
        Assertions.assertEquals(1, result);
    }

    /**
     * 1. @Transactional: 事务
     * 2. @Rollback: 回滚
     * 3. @Test: 测试方法
     * 4. verify: 验证方法是否被调用
     * 5. when: 模拟方法返回值
     * 6. Assertions.assertEquals: 断言
     */
    @Transactional
    @Rollback
    @Test
    void deleteUserById() {
        long id = 1;
        when(userMapper.deleteUserById(id)).thenReturn(1);
        int result = userService.deleteUserById(id);
        verify(userMapper).deleteUserById(id);
        Assertions.assertEquals(1, result);
    }
}