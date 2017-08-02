/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Web;

import com.demo.Model.Userinfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Smalli
 */
@RestController
public class IndexController {
    
    @Autowired
    UsersService usersService;
    
    /**
     * @param page
     * @param size
     * 查询用户
     * @return 全部用户信息
     */
    @RequestMapping(value="/findAll", method = RequestMethod.GET)
    public Page<Userinfo> findAll(@RequestParam Integer page, @RequestParam Integer size){
        //直接返回JSON数据
        return usersService.findAll(page,size);
    }
    
    /**
     * 添加用户
     * @param users
     * @param page
     * @param size
     * @return 查询全部用户信息
     */
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public Page<Userinfo> saveUser(
            @RequestBody Userinfo users,
            @RequestParam Integer page,
            @RequestParam Integer size){
        usersService.save(users);
        //直接返回JSON数据
        return usersService.findAll(page, size);
    } 
    
    /**
     * 删除用户
     * @param users
     * @param page
     * @param size
     * @return 查询全部用户信息
     */
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public Page<Userinfo> deleteUser(
            @RequestBody Userinfo users,
            @RequestParam Integer page,
            @RequestParam Integer size){
        usersService.delete(users);
        //直接返回JSON数据
        return usersService.findAll(page, size);
    }
    
    /**
     * 根据id查询用户信息
     * @param users
     * @return 
     */
    @RequestMapping(value="/findById", method = RequestMethod.POST)
    public Userinfo findByIdUser(
            @RequestBody Userinfo users){
        return usersService.findById(users.getId());
    }
    
    

}
