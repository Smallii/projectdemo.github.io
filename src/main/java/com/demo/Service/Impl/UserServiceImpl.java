/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Service.Impl;

import com.demo.Mapper.UserMapper;
import com.demo.Model.User;
import com.demo.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Smalli
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    
    @Override
    public List<User> findAll() {
        System.out.println("进入接口实现类1");
        return userMapper.findAll();
    }

    @Override
    public User save(User user) {
        return userMapper.save(user);
    }

    @Override
    public void delete(User user) {
        userMapper.delete(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
    
}
