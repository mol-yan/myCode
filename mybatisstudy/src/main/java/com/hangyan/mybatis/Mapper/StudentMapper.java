package com.hangyan.mybatis.Mapper;

import com.hangyan.mybatis.model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentMapper {
    @Select("select * from student")
    List<Student> selectAll();
//#{对象字段}
    @Insert("insert into student(s_id,s_name,s_birth,s_sex)values(#{s_id},#{s_name},#{s_birth},#{s_sex})")
    void insert(Student student);

    @Delete("delete from student where id =#{id}")
    void deleteById(int id);

    @Update("UPDATE Student set s_id=#{s_id},s_name=#{s_name},s_birth=#{s_birth},s_sex=#{s_sex}")
    void update(Student student);

}
