package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping
    public Result<?> save(@RequestBody User user){
        userMapper.insert(user);
        return Result.success();

    }

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUserName, user.getUserName())
                .eq(User::getPassword, user.getPassword()));
        if (res == null){
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success(res);

    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUserName, user.getUserName()));
        if (res != null){
            return Result.error("-1","用户名重复");
        }
        if (user.getPassword()==null){
            user.setPassword("123456");
        }
        userMapper.insert(user);
        return Result.success();

    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (StringUtils.isNotBlank(search)){
            wrapper.like(User::getUserName,search);
        }

        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize),
                wrapper);

        return Result.success(userPage);


    }

    @PutMapping
    public Result<?> update(@RequestBody User user){
        userMapper.updateById(user);
        return Result.success();

    }

    @DeleteMapping("/{userId}")
    public Result<?> delete(@PathVariable Long userId){
        userMapper.deleteById(userId);
        return Result.success();

    }
    @GetMapping("/{userId}")
    public Result<?> userInfo(@PathVariable Long userId){
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUserId, userId));
        return Result.success(user);

    }

}
