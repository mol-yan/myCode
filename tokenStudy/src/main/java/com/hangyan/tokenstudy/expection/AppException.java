package com.hangyan.tokenstudy.expection;

import com.hangyan.tokenstudy.constans.ErrorCode;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    /**
     * 错误编码
     */
    protected ErrorCode errCode;

    /**
     * 错误信息
     */
    protected String errMsg;

    /**
     * 无参构造函数
     */
    public AppException() {
        super();
    }
    public AppException(Throwable e) {
        super(e);
    }

    public AppException(ErrorCode errCode, String... errMsg) {
        //可以在这地方打印想要的
        super(errCode.getMsg());
        this.errCode = errCode;
        setErrMsg(errMsg,true);
        setErrCode(errCode);
    }

    public AppException(ErrorCode errCode, String errMsg,Boolean isTransfer) {
        super(errMsg);
        this.errCode = errCode;
        setErrMsg(new String[]{errMsg},isTransfer);
        setErrCode(errCode);
    }

    /**
     * 构造函数
     *
     * @param cause 异常
     */
    public AppException(ErrorCode errCode, Throwable cause, String... errMsg) {
        super(errCode.getCode() + errCode.getMsg(), cause);
        this.errCode = errCode;
        setErrMsg(errMsg,true);
        setErrCode(errCode);
    }

    public ErrorCode getErrCode() {
        return errCode;
    }

    public void setErrCode(ErrorCode errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String[] errMsg,Boolean isTransfer) {

        if (null != errMsg &&errMsg.length>0) {
            if(errCode.getMsg().contains("%s") && isTransfer){
                this.errMsg = String.format(errCode.getMsg(), errMsg);
            }else{
                StringBuffer sf = new StringBuffer();
                for (String msg : errMsg) {
                    sf.append(msg+";");
                }
                this.errMsg = sf.toString();
            }
        }else{
            this.errMsg = errCode.getMsg();
        }

    }



}
