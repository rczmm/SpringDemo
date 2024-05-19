package com.rczmm.demo.controller;

import com.rczmm.demo.domain.User;
import com.rczmm.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户，存储用户信息Controller
 *
 * @author rczmm
 * @date 2024-05-13
 */
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
    @PutMapping("/edit")
    public int edit(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 删除用户，存储用户信息
     *
     * @param ids 用户，存储用户信息ID
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public int remove(@PathVariable Long[] ids) {
        return userService.deleteUserByIds(ids);
    }
}
