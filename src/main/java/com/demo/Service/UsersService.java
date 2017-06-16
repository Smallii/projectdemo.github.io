/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Service;

import com.demo.Model.Users;
import java.util.List;

/**
 *
 * @author Smalli
 */
public interface UsersService {
    /**
     * 
     * @return 显示全部用户信息
     */
    List<Users> findAll();
    /**
     * @param users
     * @return 添加用户
     */
    Users save(Users users);
    /**
     * 删除用户
     * @param users
     */
    void delete(Users users);
    
    /**
     * 根据id查询用户信息
     * @param uid
     * @return 
     */
    Users findById(Long uid);
}
