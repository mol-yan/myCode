package com.hangyan.mybatis.Mapper;

import com.hangyan.mybatis.model.Course;
import com.hangyan.mybatis.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CourseMapper {

    List<Course> SelectAll();
    void update(Course student);
    void deleteById(String id);
    void insert(Course student);


}
