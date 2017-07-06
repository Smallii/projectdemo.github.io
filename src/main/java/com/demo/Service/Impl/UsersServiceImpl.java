/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Service.Impl;

import com.demo.Model.Userinfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.Mapper.UserinfoMapper;
import com.demo.Service.UsersService;

/**
 *
 * @author Smalli
 */
@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserinfoMapper usersMapper;
    
    @Override
    public List<Userinfo> findAll() {
        System.out.println("进入接口实现类1");
        return usersMapper.findAll();
    }

    @Override
    public Userinfo save(Userinfo users) {
        return usersMapper.save(users);
    }

    @Override
    public void delete(Userinfo users) {
        usersMapper.delete(users);
    }

    @Override
    public Userinfo findById(Long id) {
        return usersMapper.findById(id);
    }
    
}
