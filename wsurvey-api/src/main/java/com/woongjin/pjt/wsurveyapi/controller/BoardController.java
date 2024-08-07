package com.woongjin.pjt.wsurveyapi.controller;


import com.woongjin.pjt.wsurveyapi.entity.Board;
import com.woongjin.pjt.wsurveycore.entity.ApiResponse;
import com.woongjin.pjt.wsurveycore.enums.ErrorCode;
import com.woongjin.pjt.wsurveycore.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BoardController {
    @PostMapping("/insertBoard")
    public ResponseEntity<ApiResponse> insertBoard(@Validated @RequestBody Board board, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            // Validation 에러 처리
            log.info(bindingResult.getFieldError().getDefaultMessage());
            return ResponseEntity.ok().body(new ApiResponse<>(false, bindingResult.getFieldError().getDefaultMessage(), null));
        }
        boolean contentOpenYn = Boolean.parseBoolean(board.getIsContentOpenYn());
        return ResponseEntity.ok().body(new ApiResponse<>(true, "board객체 검증성공!!", board));
    }

    @PostMapping("/exceptionTest")
    public ResponseEntity<Void> exceptionTest(){
        throw new BusinessException(ErrorCode.FORBIDDEN);
    }

}
