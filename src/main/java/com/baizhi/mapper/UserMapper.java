package com.baizhi.mapper;

import com.baizhi.dto.UserDto;
import com.baizhi.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    Integer queryUserCount(Integer key);

    List<UserDto> queryBySex(Integer sex);
}
