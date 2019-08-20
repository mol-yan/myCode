package com.hangyan.tokenstudy.constans;

public enum TokenErroeCodeEnum implements ErrorCode {
    NOT_FIND_TOKEN("TOKEN_400","找不到token"),
    VERTY_FAILED("TOKEN_401","验证失败"),
    NOT_FIND_USER("TOKEN_400","用户不存在");


    private String code;
    private String msg;
    private TokenErroeCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;

    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
