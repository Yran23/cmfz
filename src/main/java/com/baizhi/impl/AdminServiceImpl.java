package com.baizhi.impl;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public void login(Admin admin) {
        Admin admin1 = adminMapper.selectOne(admin);
        if (admin == null)
            throw new RuntimeException("用户名或密码错误");
        admin.setId(admin1.getId());
    }
}
