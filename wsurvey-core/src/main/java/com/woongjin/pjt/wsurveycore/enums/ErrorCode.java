package com.woongjin.pjt.wsurveycore.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //httpStatus와, code, message로 구성된 enum 정의
    BAD_REQUEST(400,"E001","잘못된 요청입니다.")
    ,INVALID_PARAMS(400,"E002","필수데이터가 누락되었습니다.")
    ,UNAUTHORIZED(401, "E003","인증에 실패하였습니다.")
    ,UNAVAILABLE(401, "E004","토큰 정보가 유효하지 않습니다.")
    ,FORBIDDEN(403,"E005","접근이 금지되었습니다.")
    ,NOT_FOUND(404,"E006","리소스를 찾을 수 없습니다.")
    ,SERVER_ERROR(500,"E007","요청을 처리하는 도중 예기치 않은 오류가 발생하였습니다.")
    ,CUSTOM_ERROR(500,"E999","");

    private final int httpStatus; // header로 반환할 httpstatus code
    private final String code; // payload로 반환할 에러코드
    private final String message; // 에러코드 문서화를 위한 설명

}
