/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Web;

import com.demo.Model.User;
import com.demo.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Smalli
 */
@Controller
public class IndexController {
    
    @Autowired
    UserService userService;
    
    /**
     * 显示主页
     * @return 
     */
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index(){
        System.out.println("跳转...");
        return "welcome";
    }
    
    /**
     * 查询用户
     * @param val
     * @return 全部用户信息
     */
    @RequestMapping(value="/findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll(String val){
        //return "welcome";
        //直接返回JSON数据
        return userService.findAll();
    }
    
    /**
     * 添加用户
     * @param user
     * @return 查询全部用户信息
     */
    @RequestMapping(value="/save", method = RequestMethod.POST)
    @ResponseBody
    public List<User> saveUser(
            @RequestBody User user){
        userService.save(user);
        //直接返回JSON数据
        return userService.findAll();
    } 
    
    /**
     * 删除用户
     * @param user
     * @return 查询全部用户信息
     */
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    @ResponseBody
    public List<User> deleteUser(
            @RequestBody User user){
        userService.delete(user);
        //直接返回JSON数据
        return userService.findAll();
    }
    
    /**
     * 根据id查询用户信息
     * @param user
     * @return 
     */
    @RequestMapping(value="/findById", method = RequestMethod.POST)
    @ResponseBody
    public User findByIdUser(
            @RequestBody User user){
        return userService.findById(user.getId());
    }
}
