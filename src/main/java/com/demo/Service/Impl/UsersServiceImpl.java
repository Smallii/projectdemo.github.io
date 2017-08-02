/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Service.Impl;

import com.demo.Model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.Mapper.UserinfoMapper;
import com.demo.Service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    public Page<Userinfo> findAll(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return usersMapper.findAll(pageable);
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
