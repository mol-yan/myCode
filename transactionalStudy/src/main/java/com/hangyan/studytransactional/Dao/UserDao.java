package com.hangyan.studytransactional.Dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    public void subMoney(@Param(value = "id") int id, @Param(value = "money") double money);

    public void addMoney(@Param(value = "id") int id, @Param(value = "money") double money);
}
