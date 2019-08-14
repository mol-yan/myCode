package com.hangyan.redis_study.controller;

import com.alibaba.fastjson.JSON;
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
@CacheConfig(cacheNames = "CourseController")
@RestController
public class CourseController {
    @Resource
    CourseMapper courseMapper;
    @Resource
    RedisService redisService;


    @RequestMapping("/getCourse")
    @Cacheable()
    public List<Course> getAllCourse() {

        return this.courseMapper.SelectAll();
    }

    @Cacheable(keyGenerator = "simpleKeyGenerator")
    @RequestMapping("/course/{id}")
    public Object getCourseInfoCache(@PathVariable String id) {
        System.out.println("从数据库中获取"+id);
        //改成JSON试试
        return JSON.toJSON(courseMapper.getCourseInfo(id));

    }



    @RequestMapping("/course_/{c_id}/{t_id}/{c_name}")
//    @CachePut(key ="p0")
    @CachePut(keyGenerator = "simpleKeyGenerator")//插入语句是第一次插入，所以不用考虑数据库和redis不一的情况
    public Object insetCourse(@PathVariable String c_id,@PathVariable String t_id,@PathVariable String c_name){

        courseMapper.Insert(c_id,t_id,c_name);
        System.out.println("注入数据库成功");
        Course c = new Course();
        c.setC_id(c_id);
        c.setT_id(t_id);
        c.setC_name(c_name);
        return JSON.toJSON(c);



    }



//    @RequestMapping("/getCourses")
//    public void getCourse()
//    {
//       System.out.println(this.redisService.get("getCourseInfoCache::01"));
//
//    }
    @RequestMapping("/put/{c_id}/{t_id}")
    @CachePut(keyGenerator = "simpleKeyGenerator")//更新语句肯定会导致redis与数据库不一
    public  Object update(@PathVariable String c_id,@PathVariable String t_id)
    {
        courseMapper.update(c_id,t_id);
        System.out.println("更新"+c_id+"成功");
        //更新语句肯定会导致redis与数据库不一,初步考虑两种方法
        //a、更新完在查一下数据库，把新的放入cache中
        //b、用redis模板删除原有的，然后重写
        Course c =courseMapper.getCourseInfo(c_id);
        //如果redis已经存在需要更改的id，CachePut会根据id更改他的值，不会造成冲突
        return JSON.toJSON(c);

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










