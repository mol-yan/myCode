package com.hangyan.redis_study.controller;

import com.hangyan.redis_study.Mapper.CourseMapper;
import com.hangyan.redis_study.model.Course;
import com.hangyan.redis_study.service.RedisService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
//需要开启事务？
@CacheConfig(cacheNames = "CourseController")
@RestController
public class CourseController {
    @Resource
    CourseMapper courseMapper;
    @Resource
    RedisService redisService;


    @RequestMapping("/getCourse")
    @Cacheable(value = "getAllCourse")
    public List<Course> getAllCourse() {

        return this.courseMapper.SelectAll();
    }

    @Cacheable(value = "getCourseInfoCache",key="'c_'+#p0")
    @RequestMapping("/course/{id}")
    public Course getCourseInfoCache(@PathVariable String id) {
        id="c_"+id;
        System.out.println("从数据库中获取"+id);
        return  this.courseMapper.getCourseInfo(id);

    }
    @RequestMapping("/course_/{c_id}/{t_id}/{c_name}")
    @CachePut(key ="'c_'+#p0")
    public void insetCourse(@PathVariable String c_id,@PathVariable String t_id,@PathVariable String c_name){
        courseMapper.Insert(c_id,t_id,c_name);
        System.out.println("注入数据库成功");



    }



//    @RequestMapping("/getCourses")
//    public void getCourse()
//    {
//       System.out.println(this.redisService.get("getCourseInfoCache::01"));
//
//    }
    @RequestMapping("/put/{c_id}/{t_id}")
    @CachePut(key ="'c_'+#p0")
    public  void update(@PathVariable String c_id,@PathVariable String t_id)
    {
        courseMapper.update(c_id,t_id);
        System.out.println("更新成功");
    }

    @RequestMapping("/del/{id}")
    @CacheEvict(key = "#p0")
    public void deleteByc_id(@PathVariable String id)
    {
        courseMapper.deleteById(id);
        System.out.println("delete completed: "+id );
    }









//
//    @RequestMapping("/getCourse")
//    public List<Course> getCourse()
//    {
//        List<Course>courses =courseMapper.SelectAll();
//        return  courses;
//
//    }

//    @ResponseBody
//    @RequestMapping("/course/{id}")
//    public Course getCourseInfoCache(@PathVariable String id) {
//        Course course = (Course) redisService.get("c_" + id);
//        if (course == null) {
//            System.out.println("redis is not exist this id");
//            Course courseDB = courseMapper.getCourseInfo(id);
//            if (courseDB != null) {
//                System.out.println("找到信息" + id);
//                redisService.set("c_" + id, courseDB);
//                System.out.println("存入redis中成功");
//                return courseDB;
//            }
//        }
//        return course;
//    }
//
//
//








    }










