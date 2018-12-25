package com.baizhi.controller;

import com.baizhi.dto.UserDto;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserCount")
    public List<Integer> queryUserCount() {
        return userService.queryUserCount();
    }

    @RequestMapping("/queryBySex")
    public List<UserDto> queryBySex(Integer sex) {
        return userService.queryBySex(sex);
    }
}
