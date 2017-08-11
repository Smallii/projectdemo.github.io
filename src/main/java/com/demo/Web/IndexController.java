/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Web;

import com.demo.Model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Service.UsersService;
import com.demo.Util.SocketMessage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Smalli
 */
@EnableScheduling
@RestController
public class IndexController {
    
    @Autowired
    UsersService usersService;
    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    /**
     * @param page
     * @param size
     * 查询用户
     * @return 全部用户信息
     */
    @RequestMapping(value="/findAll", method = RequestMethod.GET)
    public Map<String, Object> findAll(
            @RequestParam Integer page,
            @RequestParam Integer size){
        Map<String, Object> resuMap = new HashMap<>();
        List<Userinfo> userinfos = new ArrayList<>();
        if (page == null){
            page = 1;
        }
        if (size == null){
            size = 10;
        }
        Page<Userinfo> userInfolist = usersService.findAll(page,size);
        for (Userinfo userinfo : userInfolist) {
            System.out.println("com.demo.Web.IndexController.findAll():"+ userinfo.getName() +"======="+ userinfo.getNick() +"======="+ userinfo.getId());
            Userinfo u = new Userinfo();
            u.setId(userinfo.getId());
            u.setName(userinfo.getName());
            u.setNick(userinfo.getNick());
            userinfos.add(u);
        }
        resuMap.put("data", userinfos);
        //直接返回JSON数据
        return resuMap;
    }
    
    /**
     * 添加用户
     * @param users
     * @return 查询全部用户信息
     */
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public Page<Userinfo> saveUser(
            @RequestBody Userinfo users){
        usersService.save(users);
        //直接返回JSON数据
        return usersService.findAll(1, 10);
    } 
    
    /**
     * 删除用户
     * @param users
     * @return 查询全部用户信息
     */
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public Page<Userinfo> deleteUser(
            @RequestBody Userinfo users){
        usersService.delete(users);
        //直接返回JSON数据
        return usersService.findAll(1, 10);
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
    
    @MessageMapping("/send")
	@SendTo("/topic/send")
	public SocketMessage send(SocketMessage message) throws Exception {
            System.out.println("com.example.App.send()");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		message.date = df.format(new Date());
		return message;
	}

	@Scheduled(fixedRate = 1000)
	@SendTo("/topic/callback")
	public Object callback() throws Exception {
		// 发现消息
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		messagingTemplate.convertAndSend("/topic/callback", df.format(new Date()));
		return "callback";
	}

}
