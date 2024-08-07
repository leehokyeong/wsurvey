package com.woongjin.pjt.wsurveyapi.controller;

import com.woongjin.pjt.wsurveycore.entity.ErrorResponse;
import com.woongjin.pjt.wsurveycore.enums.ErrorCode;
import com.woongjin.pjt.wsurveycore.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getCode(), errorCode.getMessage()); // errorResponse 생성자
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getHttpStatus()));
        //return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse); // enum에 정의한 httpStatus를 상태값으로, body에는 errorResponse를 return
    }

}
