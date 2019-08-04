package com.hangyan.mybatis.model;

import java.util.Date;

public class Student {
    int s_id;
    String s_name;
    Date s_birth;
    String s_sex;

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Date getS_birth() {
        return s_birth;
    }

    public void setS_birth(Date s_birth) {
        this.s_birth = s_birth;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }
}
