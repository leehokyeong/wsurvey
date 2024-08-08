package com.woongjin.pjt.wsurveyweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class User {
    @NotBlank(message = "사번은 필수입력")
    @Pattern(regexp = "^[0-9]+$", message = "사번은 숫자만 가능")
    @Size(min = 8, max = 8, message = "사번은 8글자만 가능")
    private String eno;
    
    @NotBlank(message = "이름은 필수입력")
    @Pattern(regexp = "^[가-힣a-zA-Z]+$", message = "이름은 한글 또는 영어만 입력가능")
    private String name;
    
    @NotBlank(message = "생년월일은 필수입력")
    @Pattern(regexp = "^[0-9]+$", message = "생년월일은 숫자만 가능")
    @Size(min = 8, max = 8, message = "생년월일은 8글자만 가능")
    private String birth;
    
    @NotBlank(message = "휴대전화번호는 필수입력")
    @Pattern(regexp = "^[0-9]+$", message = "휴대전화번호는 숫자만 가능")
    @Size(min = 10, max = 11, message = "휴대전화번호는 최소 10자 최대11자")
    private String cgagTno;
}
