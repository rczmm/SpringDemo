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

@ExtendWith(MockitoExtension.class)
class CorpServiceImplTest {

    @Mock
    private CorpMapper corpMapper;


    @InjectMocks
    private CorpServiceImpl corpService;


    @BeforeEach
    void setUp() {
        System.out.println("开始测试");
        corpService = new CorpServiceImpl(corpMapper);
    }

    @AfterEach
    void tearDown() {
        System.out.println("测试结束");
        corpService = null;
    }

    @Transactional(readOnly = true)
    @Test
    void selectCorpById() {
        long id = 1;
        corpMapper.selectCorpById(id);
        verify(corpMapper).selectCorpById(id);
    }

    @Transactional(readOnly = true)
    @Test
    void selectCorpList() {
        Corp corp = new Corp();
        corpMapper.selectCorpList(corp);
        verify(corpMapper).selectCorpList(corp);
    }

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