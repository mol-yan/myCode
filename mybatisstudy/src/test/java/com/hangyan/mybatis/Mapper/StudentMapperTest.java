package com.hangyan.mybatis.Mapper;

import com.hangyan.mybatis.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentMapperTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testSelectAll(){
        List<Student> students =studentMapper.selectAll();
        for (Student s:students)
        {
            System.out.println(s.getS_sex());
            System.out.println(s.getS_name());
        }
    }

//    @Test
//    public void testInsert()
//    {
//        Student student=new Student();
//        student.setS_birth(new Date());
//        student.setS_id(10);
//        student.setS_name("沥干");
//        student.setS_sex("男");
//        studentMapper.insert(student);
//    }
//    @Test
//    public void testDelete()
//    {
//        studentMapper.deleteById(7);
//    }
//    @Test
//    public void testUpdate()
//    {
//        Student student=new Student();
//        student.setS_birth(new Date());
//        student.setS_id(9);
//        student.setS_name("沥2干");
//        student.setS_sex("男");
//        studentMapper.update(student);
//    }

}
