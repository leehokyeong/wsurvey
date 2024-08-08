package com.woongjin.pjt.wsurveycore.exception;

import com.woongjin.pjt.wsurveycore.enums.ErrorCode;

public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

    // throw new BusinessException() 발생시킬 생성자
    // 에러코드 enum에 정의한 exception 메세지
    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    // 사용자 정의 exception 메세지
    public BusinessException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    // @ExceptionHandler(BusinessException.class) 에서 사용할 errorCode
    public ErrorCode getErrorCode()
    {
        return errorCode;
    }
}
