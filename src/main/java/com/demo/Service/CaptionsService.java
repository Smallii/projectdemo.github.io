/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Service;

import com.demo.Model.Captions;
import java.util.List;

/**
 *
 * @author Smalli
 */
public interface CaptionsService {
    /**
     * 查询全部Captions，banner
     * @return 
     */
    List<Captions> findAll();
}
