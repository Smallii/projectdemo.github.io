/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Service;

import com.demo.Model.User;
import java.util.List;

/**
 *
 * @author Smalli
 */
public interface UserService {
    /**
     * 
     * @return 显示全部用户信息
     */
    List<User> findAll();
    /**
     * @param user
     * @return 添加用户
     */
    User save(User user);
    /**
     * 删除用户
     * @param user
     */
    void delete(User user);
    
    /**
     * 根据id查询用户信息
     * @param id
     * @return 
     */
    User findById(Integer id);
}
