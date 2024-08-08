package com.woongjin.pjt.wsurveyapi.controller;

import com.woongjin.pjt.wsurveycore.entity.ErrorResponse;
import com.woongjin.pjt.wsurveycore.enums.ErrorCode;
import com.woongjin.pjt.wsurveycore.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
/**
 * Controller 내에서 발생하는 Exception 대해서 Catch 하여 응답값(Response)을 보내주는 기능을 수행
 */
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex){
        log.info("비즈니스익셉션발생!!!!!!!!!!!!!!!!!!!!!!!!!");
        ErrorCode errorCode = ex.getErrorCode();
        String message = errorCode.getMessage();

        // 사용자정의 메세지가 있을경우 enum 메세지가 아닌 해당 메세지 return
        if(!ex.getMessage().isEmpty()){
            message = ex.getMessage();
        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                                                    .code(errorCode.getCode())
                                                    .message(message)
                                                    .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getHttpStatus()));
    }

}
