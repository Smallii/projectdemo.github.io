/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Service;

import com.demo.Model.Userinfo;
import org.springframework.data.domain.Page;

/**
 *
 * @author Smalli
 */
public interface UsersService {
    /**
     * 
     * @param page
     * @param size
     * @return 显示全部用户信息
     */
    Page<Userinfo> findAll(Integer page, Integer size);
    /**
     * @param users
     * @return 添加用户
     */
    Userinfo save(Userinfo users);
    /**
     * 删除用户
     * @param users
     */
    void delete(Userinfo users);
    
    /**
     * 根据id查询用户信息
     * @param id
     * @return 
     */
    Userinfo findById(Long id);
}
