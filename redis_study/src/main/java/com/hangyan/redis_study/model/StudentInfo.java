package com.hangyan.redis_study.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
//@Component
public class StudentInfo implements Serializable {
    String s_id;
    String s_name;
    String  s_birth;
    String s_sex;
    //对象的依赖注入，返回是list，清楚原因，但是如果有班级属性，班级返回的是一个类不是一个集合，因为班级是唯一的。
    List<Course> course;
    //映射的结果，一个学生会出现多门课(所以把课程设置为List)，同样会有多个成绩
    List<Score> scores;

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_birth() {
        return s_birth;
    }

    public void setS_birth(String s_birth) {
        this.s_birth = s_birth;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
