package com.hangyan.tokenstudy.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface IuserDao {

     String userLogin(@Param(value = "userCode") String userCode);

}
