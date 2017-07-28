/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Web;

import com.demo.Model.Captions;
import com.demo.Service.CaptionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Smalli
 */
@RestController
public class CaptionsController {
    
    @Autowired
    CaptionsService captionsService;
    
    /**
     * 查询全部Captions，banner
     * @return 
     */
    @RequestMapping(value="/findAll_caption", method = RequestMethod.POST)
    public List<Captions> findAll(){
        System.out.println("获取banner图片");
        List<Captions> csd = captionsService.findAll();
        for (Captions captions : csd) {
            System.out.println("com.demo.Web.CaptionsController.findAll()" + captions.getPhotosPath());
        }
        return captionsService.findAll();
    }
}
