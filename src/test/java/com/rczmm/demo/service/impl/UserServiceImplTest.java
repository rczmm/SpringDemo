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

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        System.out.println("开始测试");
        userService = new UserServiceImpl(userMapper);
    }

    @AfterEach
    void tearDown() {
        System.out.println("测试结束");
        userService = null;
    }

    @Transactional(readOnly = true)
    @Test
    void selectUserById() {
        long id = 1;
        userService.selectUserById(id);
        verify(userMapper).selectUserById(id);
    }

    @Transactional(readOnly = true)
    @Test
    void selectUserList() {
        User user = new User();
        userService.selectUserList(user);
        verify(userMapper).selectUserList(user);
    }

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