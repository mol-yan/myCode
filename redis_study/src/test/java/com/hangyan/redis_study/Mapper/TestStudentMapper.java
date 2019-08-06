package com.hangyan.redis_study.Mapper;


import com.hangyan.redis_study.Mapper.StudentMapper;
import com.hangyan.redis_study.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestStudentMapper {

    @Autowired
    StudentMapper studentMapper;
    @Test
    public void teseSelect()
    {
        List<Student> students = studentMapper.selectAll();
        for(Student s : students)
        {
            System.out.println(s.getS_name()+" "+s.getS_sex()+" "+s.getS_birth()+" "+s.getS_id());
        }

    }

}
