package com.rczmm.demo.service.impl;

import com.rczmm.demo.domain.Corp;
import com.rczmm.demo.mapper.CorpMapper;
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
class CorpServiceImplTest {

    /**
     * 1. @Mock 指定要模拟的类
     */
    @Mock
    private CorpMapper corpMapper;


    /**
     * 1. @InjectMocks 指定要测试的类
     */
    @InjectMocks
    private CorpServiceImpl corpService;


    /**
     * 1. @BeforeEach 指定测试前的方法
     * 2. 在这里初始化要测试的类
     */
    @BeforeEach
    void setUp() {
        System.out.println("开始测试");
        corpService = new CorpServiceImpl(corpMapper);
    }

    /**
     * 1. @AfterEach 指定测试后的方法
     * 2. 在这里清理要测试的类
     */
    @AfterEach
    void tearDown() {
        System.out.println("测试结束");
        corpService = null;
    }

    /**
     * 1. @Transactional(readOnly = true): 只读事务
     * 2. @Test: 测试方法
     * 3. verify: 验证方法是否被调用
     */
    @Transactional(readOnly = true)
    @Test
    void selectCorpById() {
        long id = 1;
        corpMapper.selectCorpById(id);
        verify(corpMapper).selectCorpById(id);
    }

    /**
     * 1. @Transactional(readOnly = true): 只读事务
     * 2. @Test: 测试方法
     * 3. verify: 验证方法是否被调用
     */
    @Transactional(readOnly = true)
    @Test
    void selectCorpList() {
        Corp corp = new Corp();
        corpMapper.selectCorpList(corp);
        verify(corpMapper).selectCorpList(corp);
    }

    /**
     * 1. @Transactional(readOnly = true): 只读事务
     * 2. @Test: 测试方法
     * 3. verify: 验证方法是否被调用
     * 4. when: 模拟方法返回值
     * 5. Assertions.assertEquals: 断言
     */
    @Transactional
    @Rollback
    @Test
    void insertCorp() {
        Corp corp = new Corp();
        corp.setPid(2L);
        corp.setType("诈骗部");
        corp.setStatus("1");
        corp.setName("诈骗司");
        corp.setCreateTime("2020-01-01 12:00:00");
        corp.setUpdateTime("2021-01-01 12:00:00");
        corp.setDescription("诈骗公司");
        when(corpMapper.insertCorp(corp)).thenReturn(1);
        int result = corpMapper.insertCorp(corp);
        verify(corpMapper).insertCorp(corp);
        Assertions.assertEquals(1, result);
    }

    /**
     * 1. @Transactional(readOnly = true): 只读事务
     * 2. @Test: 测试方法
     * 3. verify: 验证方法是否被调用
     * 4. when: 模拟方法返回值
     * 5. Assertions.assertEquals: 断言
     */
    @Transactional
    @Rollback
    @Test
    void updateCorp() {
        Corp corp = new Corp();
        corp.setId(1L);
        corp.setPid(2L);
        corp.setType("诈骗部");
        corp.setStatus("1");
        corp.setName("诈骗司");
        corp.setCreateTime("2020-01-01 12:00:00");
        corp.setUpdateTime("2021-01-01 12:00:00");
        corp.setDescription("诈骗公司");
        when(corpMapper.updateCorp(corp)).thenReturn(1);
        int result = corpMapper.updateCorp(corp);
        verify(corpMapper).updateCorp(corp);
        Assertions.assertEquals(1, result);
    }

    /**
     * 1. @Transactional(readOnly = true): 只读事务
     * 2. @Test: 测试方法
     * 3. verify: 验证方法是否被调用
     * 4. when: 模拟方法返回值
     * 5. Assertions.assertEquals: 断言
     */
    @Transactional
    @Rollback
    @Test
    void deleteCorpByIds() {
        Long[] ids = {1L, 2L};
        when(corpMapper.deleteCorpByIds(ids)).thenReturn(1);
        int result = corpMapper.deleteCorpByIds(ids);
        verify(corpMapper).deleteCorpByIds(ids);
        Assertions.assertEquals(1, result);
    }

    /**
     * 1. @Transactional(readOnly = true): 只读事务
     * 2. @Test: 测试方法
     * 3. verify: 验证方法是否被调用
     * 4. when: 模拟方法返回值
     * 5. Assertions.assertEquals: 断言
     */
    @Transactional
    @Rollback
    @Test
    void deleteCorpById() {
        long id = 1;
        when(corpMapper.deleteCorpById(id)).thenReturn(1);
        int result = corpMapper.deleteCorpById(id);
        verify(corpMapper).deleteCorpById(id);
        Assertions.assertEquals(1, result);
    }
}