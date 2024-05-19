package com.rczmm.demo.controller;

import com.rczmm.demo.domain.Corp;
import com.rczmm.demo.service.ICorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 部门，存储部门信息Controller
 *
 * @author rczmm
 * @date 2024-05-13
 */
@RestController
@RequestMapping("/demo/corp")
public class CorpController {

    private final ICorpService corpService;

    @Autowired
    public CorpController(ICorpService corpService) {
        this.corpService = corpService;
    }

    /**
     * 查询部门，存储部门信息列表
     *
     * @param corp 部门对象
     * @return 部门，存储部门信息集合
     */
    @GetMapping("/list")
    public List<Corp> list(Corp corp) {
        return corpService.selectCorpList(corp);
    }

    /**
     * 查询部门，存储部门信息详细
     *
     * @param id 部门，存储部门信息ID
     * @return 部门，存储部门信息
     */
    @GetMapping(value = "/{id}")
    public Corp getInfo(@PathVariable("id") Long id) {
        return corpService.selectCorpById(id);
    }

    /**
     * 新增部门，存储部门信息
     *
     * @param corp 部门，存储部门信息
     * @return 结果
     */
    @PostMapping("/add")
    public int add(@RequestBody Corp corp) {
        return corpService.insertCorp(corp);
    }

    /**
     * 修改部门，存储部门信息
     *
     * @param corp 部门，存储部门信息
     * @return 结果
     */
    @PutMapping("/edit")
    public int edit(@RequestBody Corp corp) {
        return corpService.updateCorp(corp);
    }

    /**
     * 删除部门，存储部门信息
     *
     * @param ids 部门，存储部门信息ID
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public int remove(@PathVariable Long[] ids) {
        return corpService.deleteCorpByIds(ids);
    }
}
