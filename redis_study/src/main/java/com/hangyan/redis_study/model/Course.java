package com.hangyan.redis_study.model;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
    String c_id;
    String c_name;
    String t_id;
    List<String> c_ids;


    public List<String> getC_ids() {
        return c_ids;
    }

    public void setC_ids(List<String> c_ids) {
        this.c_ids = c_ids;
    }



    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }
}
