package com.rczmm.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rczmm.demo.domain.Corp;
import com.rczmm.demo.service.ICorpService;


/**
 * 部门，存储部门信息Controller
 * 
 * @author rczmm
 * @date 2024-05-13
 */
@RestController
@RequestMapping("/demo/corp")
public class CorpController
{
    @Autowired
    private ICorpService corpService;

    /**
     * 查询部门，存储部门信息列表
     */
    @GetMapping("/list")
    public List<Corp> list(Corp corp)
    {
        return corpService.selectCorpList(corp);
    }

    /**
     * 获取部门，存储部门信息详细信息
     */

    @GetMapping(value = "/{id}")
    public Corp getInfo(@PathVariable("id") Long id)
    {
        return corpService.selectCorpById(id);
    }

    /**
     * 新增部门，存储部门信息
     */
    @PostMapping("/add")
    public int add(@RequestBody Corp corp)
    {
        return corpService.insertCorp(corp);
    }

    /**
     * 修改部门，存储部门信息
     */
    @PutMapping("/edit")
    public int edit(@RequestBody Corp corp)
    {
        return corpService.updateCorp(corp);
    }

    /**
     * 删除部门，存储部门信息
     */
	@DeleteMapping("/{ids}")
    public int remove(@PathVariable Long[] ids)
    {
        return corpService.deleteCorpByIds(ids);
    }
}
