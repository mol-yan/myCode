package com.hangyan.redis_study.Mapper;

import com.hangyan.redis_study.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {
    @Insert("insert into student(s_id,s_name,s_birth,s_sex) values(#{s_id},#{s_name},#{s_birth},#{s_sex})")
    void add(Student student);

    @Select("select * from student where s_id=#{id}")
    Student getStudentInfoById(String id);

    @Delete("delete from student where s_id=#{id}")
    void deleteById(String id);

    @Select("select * from student")
    List<Student> selectAll();

    @Update("update student set s_birth=#{s_birth} where s_id=#{id}")
    void update(@Param(value = "s_birth") String s_birth, @Param(value = "id")String id);

}
