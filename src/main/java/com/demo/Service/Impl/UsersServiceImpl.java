/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Service.Impl;

import com.demo.Model.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.Mapper.UsersMapper;
import com.demo.Service.UsersService;

/**
 *
 * @author Smalli
 */
@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;
    
    @Override
    public List<Users> findAll() {
        System.out.println("进入接口实现类1");
        return usersMapper.findAll();
    }

    @Override
    public Users save(Users users) {
        return usersMapper.save(users);
    }

    @Override
    public void delete(Users users) {
        usersMapper.delete(users);
    }

    @Override
    public Users findById(Long uid) {
        return usersMapper.findByUid(uid);
    }
    
}
