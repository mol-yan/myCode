package com.hangyan.redis_study.Mapper;


import com.alibaba.fastjson.JSON;
import com.hangyan.redis_study.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCourseMapper {

    @Autowired
    CourseMapper courseMapper;

    @Test
    public void testSelect()
    {
       Course course=new Course();

       List<String> list = new ArrayList<>();
       list.add("01");
       list.add("02");
       list.add("03");
       course.setC_ids(list);
       List<Course> courses =courseMapper.SelectById(course);
       for (Course c: courses)
        {
            System.out.println(JSON.toJSON(c));
        }
    }
}
