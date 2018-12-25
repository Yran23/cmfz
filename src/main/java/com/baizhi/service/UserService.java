package com.baizhi.service;

import com.baizhi.dto.UserDto;

import java.util.List;

public interface UserService {
    List<Integer> queryUserCount();

    List<UserDto> queryBySex(Integer sex);
}
