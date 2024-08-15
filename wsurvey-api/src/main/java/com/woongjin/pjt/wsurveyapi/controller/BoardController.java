package com.woongjin.pjt.wsurveyapi.controller;


import com.woongjin.pjt.wsurveyapi.dto.RequestBoardDto;
import com.woongjin.pjt.wsurveycore.entity.ApiResponse;
import com.woongjin.pjt.wsurveycore.enums.ErrorCode;
import com.woongjin.pjt.wsurveycore.exception.BusinessException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "BoardController API", description = "BoardController API Docs 입니다.")
@RestController
@Slf4j
public class BoardController {
    @PostMapping("/insertBoard")
    @Operation(summary = "게시판 등록", description = "게시판에 내용을 등록하고 검증함")
    @Parameter(name="RequestBoardDto", description = "board 요청 정보")
    public ResponseEntity<ApiResponse> insertBoard(@Validated @RequestBody RequestBoardDto requestBoardDto, BindingResult bindingResult){
        ApiResponse apiResponse;
        if (bindingResult.hasErrors()) {
            // Validation 에러 처리
            log.info(bindingResult.getFieldError().getDefaultMessage());
            apiResponse = ApiResponse.builder()
                                    .success(false)
                                    .message(bindingResult.getFieldError().getDefaultMessage())
                                    .data(null)
                                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        apiResponse = ApiResponse.builder()
                                .success(true)
                                .message("board객체 검증성공!!!")
                                .data(requestBoardDto)
                                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/exceptionTest")
    @Operation(summary = "Exception test", description = "exception 메세지를 테스트함")
    public ResponseEntity<Void> exceptionTest(){
        //throw new BusinessException(ErrorCode.FORBIDDEN);
        throw new BusinessException("사용자정의 exception 메세지",ErrorCode.CUSTOM_ERROR);
    }

}
