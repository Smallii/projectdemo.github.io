/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Service.Impl;

import com.demo.Mapper.CaptionsMapper;
import com.demo.Model.Captions;
import com.demo.Service.CaptionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Smalli
 */
@Service("captionsService")
@Transactional
public class CaptionsServiceImpl implements CaptionsService{

    @Autowired
    CaptionsMapper captionsMapper;
    @Override
    public List<Captions> findAll() {
        return captionsMapper.findAll();
    }
    
}
