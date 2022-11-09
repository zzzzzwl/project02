package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @PostMapping
    public Result save(@RequestBody User user){
        return null;

    }


}
