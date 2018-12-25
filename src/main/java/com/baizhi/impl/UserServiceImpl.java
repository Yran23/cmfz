package com.baizhi.impl;

import com.baizhi.dto.UserDto;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<Integer> queryUserCount() {
        List<Integer> list = new ArrayList<>();
        int[] keys = {7, 15, 30, 90, 180, 360};
        for (int key : keys) {
            list.add(userMapper.queryUserCount(key));
        }
        return list;
    }

    public List<UserDto> queryBySex(Integer sex) {
        List<UserDto> list = userMapper.queryBySex(sex);
        return list;
    }

}
