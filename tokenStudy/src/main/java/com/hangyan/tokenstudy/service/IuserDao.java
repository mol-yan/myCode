package com.hangyan.tokenstudy.service;

import com.hangyan.tokenstudy.bo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface IuserDao {

     String getPasswd(@Param(value = "userCode") String userCode);
     User findUserById(String Id);

}
