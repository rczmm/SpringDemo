package com.rczmm.demo.controller;

import com.rczmm.demo.annotation.OperationLogAnnotation;
import com.rczmm.demo.domain.User;
import com.rczmm.demo.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户，存储用户信息Controller
 *
 * @author rczmm
 * @date 2024-05-13
 */
@Tag(name = "user", description = "")
@RestController
@RequestMapping("/demo/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 查询用户，存储用户信息列表
     *
     * @param user 用户对象
     * @return list 用户，存储用户信息集合
     */
    @Operation(summary = "查询用户，存储用户信息列表", description = "查询用户，存储用户信息列表")
    @OperationLogAnnotation(operationModule = "user", operationType = "list", operationDesc = "查询用户，存储用户信息列表")
    @GetMapping("/list")
    public List<User> list(User user) {
        return userService.selectUserList(user);
    }


    /**
     * 查询用户，存储用户信息
     *
     * @param id 用户，存储用户信息ID
     * @return 用户，存储用户信息
     */
    @Operation(summary = "查询用户，存储用户信息", description = "查询用户，存储用户信息")
    @OperationLogAnnotation(operationModule = "user", operationType = "get", operationDesc = "查询用户，存储用户信息")
    @GetMapping(value = "/{id}")
    public User getInfo(@PathVariable("id") Long id) {
        return userService.selectUserById(id);
    }

    /**
     * 新增用户，存储用户信息
     *
     * @param user 用户，存储用户信息
     * @return 结果
     */
    @Operation(summary = "新增用户，存储用户信息", description = "新增用户，存储用户信息")
    @OperationLogAnnotation(operationModule = "user", operationType = "add", operationDesc = "新增用户，存储用户信息")
    @PostMapping("/add")
    public int add(@RequestBody User user) {
        return userService.insertUser(user);
    }

    /**
     * 修改用户，存储用户信息
     *
     * @param user 用户，存储用户信息
     * @return 结果
     */
    @Operation(summary = "修改用户，存储用户信息", description = "修改用户，存储用户信息")
    @OperationLogAnnotation(operationModule = "user", operationType = "edit", operationDesc = "修改用户，存储用户信息")
    @PostMapping("/edit")
    public int edit(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 删除用户，存储用户信息
     *
     * @param ids 用户，存储用户信息ID
     * @return 结果
     */
    @Operation(summary = "删除用户，存储用户信息", description = "删除用户，存储用户信息")
    @OperationLogAnnotation(operationModule = "user", operationType = "delete", operationDesc = "删除用户，存储用户信息")
    @PostMapping("/{ids}")
    public int remove(@PathVariable Long[] ids) {
        return userService.deleteUserByIds(ids);
    }
}
