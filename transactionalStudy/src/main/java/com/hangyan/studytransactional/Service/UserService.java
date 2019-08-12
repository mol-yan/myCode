package com.hangyan.studytransactional.Service;


import com.hangyan.studytransactional.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@EnableTransactionManagement
@Service
public class UserService {

    @Resource
    UserDao userdao;

    @Transactional
    public void accountMoney(){
        userdao.addMoney(03,1000);
        int i= 10/0;
        userdao.subMoney(02,1000);
    }

}
