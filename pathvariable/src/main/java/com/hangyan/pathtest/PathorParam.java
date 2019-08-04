package com.hangyan.pathtest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/aa")
public class PathorParam {

    @RequestMapping("/bb")
    @ResponseBody
    public String getMacInfo(@Param("mac") String s)
    {
        System.out.println(s);
        return s;
    }


}
