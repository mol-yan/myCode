package com.hangyan.mybatis.Mapper;

import com.hangyan.mybatis.model.Course;
import net.minidev.json.JSONArray;
import org.json.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CoureseMapperTest {
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void testSelectAll(){
        List<Course> c= courseMapper.SelectAll();
        for (Course course:c)
        {
            System.out.print(course.getC_name());
            System.out.println(course.getC_id());
        }

    }

//    @Test
//    public void testDeleteById()
//    {
//        courseMapper.deleteById("02");
//    }
//
//    @Test
//    public void testUpdate()
//    {
//       Course course =new Course();
//       course.setC_id("2");
//       course.setC_name("语文");
//       course.setT_id("2");
//       courseMapper.update(course);
//    }
//    @Test
//    public  void testInsert()
//    {
//        Course course =new Course();
//        course.setC_id("23");
//        course.setC_name("语文");
//        course.setT_id("9");
//        courseMapper.insert(course);
//
//    }



}
