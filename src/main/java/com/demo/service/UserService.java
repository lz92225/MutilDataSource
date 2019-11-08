package com.demo.service;

import com.demo.dao.cluster.AddressMapper;
import com.demo.dao.master.UserMapper;
import com.demo.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * create by liu_zhang on 2019/11/7 18:22.
 */
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    AddressMapper addressMapper;

    public User getUser(){
        System.out.println(userMapper);
        User user = userMapper.selectByPrimaryKey(1L);
        user.setAddress(addressMapper.selectByPrimaryKey(1));
        return user;
    }
}
