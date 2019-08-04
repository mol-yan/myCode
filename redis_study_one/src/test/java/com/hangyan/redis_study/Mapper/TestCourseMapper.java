package com.hangyan.redis_study.Mapper;


import com.hangyan.redis_study.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCourseMapper {

    @Autowired
    CourseMapper courseMapper;

    @Test
    public void testSelect()
    {
        List<Course> courses =courseMapper.SelectAll();
        for (Course c: courses)
        {
            System.out.println(c.getC_id()+" "+c.getC_name()+" "+c.getT_id());
        }
    }
}
