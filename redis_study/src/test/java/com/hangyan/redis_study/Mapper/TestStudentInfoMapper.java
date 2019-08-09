package com.hangyan.redis_study.Mapper;


import com.alibaba.fastjson.JSON;
import com.hangyan.redis_study.model.StudentInfo;
import org.hibernate.validator.constraints.ISBN;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestStudentInfoMapper {

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Test
    public void testStudentInfo(){
        List<StudentInfo> list =studentInfoMapper.SelectAll();
        for (StudentInfo s: list) {
            System.out.println(JSON.toJSON(s));
        }


    }

}
