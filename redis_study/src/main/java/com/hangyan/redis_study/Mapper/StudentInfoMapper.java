package com.hangyan.redis_study.Mapper;

import com.hangyan.redis_study.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentInfoMapper {

    public List<StudentInfo>  SelectAll() ;

}
