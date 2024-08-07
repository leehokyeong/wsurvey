package com.woongjin.pjt.wsurveycore.exception;

import com.woongjin.pjt.wsurveycore.enums.ErrorCode;

public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

    // throw new BusinessException() 발생시킬 생성자
    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    // @ExceptionHandler(BusinessException.class) 에서 사용할 errorCode
    public ErrorCode getErrorCode()
    {
        return errorCode;
    }
}
