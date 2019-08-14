package com.hangyan.redis_study.controller;

import com.alibaba.fastjson.JSON;
import com.hangyan.redis_study.Mapper.StudentMapper;
import com.hangyan.redis_study.model.Student;
import com.hangyan.redis_study.service.RedisService;
import com.hangyan.redis_study.service.RedisServiceImpl;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {
    @Resource
    StudentMapper studentMapper;

    @Resource
    RedisServiceImpl redisService;

    @RequestMapping("/get")
    @ResponseBody
    public List<Student> getStudent()
    {
        List<Student>students=studentMapper.selectAll();
        return students;
    }
    @RequestMapping("/getStudentCache")
    @ResponseBody
    public Student getStudentInfoCache( String id)
    {
        Student studentInfo_Redis =(Student)redisService.get("s_"+id);
        if(studentInfo_Redis!=null)
        {
            System.out.println("已经在redis中得到"+id+"的信息");
            System.out.println(studentInfo_Redis.getS_name()+studentInfo_Redis.getS_birth()+studentInfo_Redis.getS_sex());
        }


        if(studentInfo_Redis==null){
            Student studentInfo_DB= studentMapper.getStudentInfoById(id);
            if(studentInfo_DB!=null) {
                System.out.println("该id信息在数据库中：" + id);
                System.out.println(studentInfo_DB.getS_name()+studentInfo_DB.getS_birth());
                System.out.println("即将存入redis中：" + id);
//                redisService.set(id, JSON.toJSON(studentInfo_DB));
                redisService.set("s_"+id, JSON.toJSON(studentInfo_DB));

                System.out.println("成功存入redis中：" + id);
                return studentInfo_DB;
            }else
            {
                System.out.println("该id信息不在数据库中：" + id);
            }
        }
        return studentInfo_Redis;
    }

    @RequestMapping("/add")
    @ResponseBody
    public void addStudentInfo()
    {
        String id ="112340";
        Student student =new Student();
        student.setS_birth("1984-12-22");
        student.setS_id(id);
        student.setS_name("非哥");
        student.setS_sex("男");
        studentMapper.add(student);
        redisService.set("s_"+id,JSON.toJSON(student));
        System.out.println("数据库和Redis已经完全录入");
    }

    @RequestMapping("/update")
    @ResponseBody
    public  Student updateStudentInfo()
    {
        String id="02";
        String new_birth="1983-12-03";
        Student student = this.getStudentInfoCache(id);
        student.setS_birth("1983-02-03");
        studentMapper.update(new_birth,id);
        redisService.remove("s_"+id);
        redisService.set("s_"+id,JSON.toJSON(student));

        Student student_new = this.getStudentInfoCache(id);
        return student_new;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(){
        String id ="7";
        studentMapper.deleteById(id);
        redisService.remove("s_"+id);

    }











}
