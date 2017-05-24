/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Mapper;

import com.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Smalli
 */
@Repository
public interface UserMapper extends JpaRepository<User,Integer>, JpaSpecificationExecutor {

    /**
     * 根据id查询用户信息
     * @param id
     * @return 
     */
    User findById(@Param("id") Integer id);
    
}
