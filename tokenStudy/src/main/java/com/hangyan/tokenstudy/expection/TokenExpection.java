package com.hangyan.tokenstudy.expection;

import com.hangyan.tokenstudy.constans.ErrorCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenExpection extends AppException {

    private static final long serialVersionUID = 1L;

     TokenExpection() {
        super();
    }
    public TokenExpection(Throwable e) {
        super(e);
    }
    public TokenExpection(ErrorCode errorType) {
        super(errorType);
    }

    public  TokenExpection(ErrorCode errorCode, String ... errMsg) {
        super(errorCode, errMsg);
    }
    /**
     * 封装异常
     * @param errorCode
     * @param errMsg
     * @param isTransfer 是否转换异常信息，如果为false,则直接使用errMsg信息
     */
    public TokenExpection(ErrorCode errorCode, String errMsg, Boolean isTransfer) {
        super(errorCode, errMsg,isTransfer);
    }

    public TokenExpection(ErrorCode errCode, Throwable cause, String ... errMsg) {
        super(errCode,cause, errMsg);
    }
}
