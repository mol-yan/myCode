package com.hangyan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/a")
public class Tvservice {
    @GetMapping("/{b}")
    public Map<String, Object>say(){

        Map<String,Object> res= new HashMap<>();
        res.put("message","hellow,world");
        return res;
    }
}
