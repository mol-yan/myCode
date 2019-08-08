package com.hangyan.redis_study.Mapper;

import com.hangyan.redis_study.model.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Component
public interface CourseMapper {

    public void Insert( @Param(value = "c_id") String c_id,@Param(value = "t_id") String  t_id,@Param(value = "c_name")String c_name);
    public void deleteById(String id);
    public List<Course> SelectAll();
    public void update(@Param(value = "c_id") String c_id,@Param(value = "t_id") String  t_id);
    public Course getCourseInfo(String id);

    public List<Course> SelectById(Course course);


}
